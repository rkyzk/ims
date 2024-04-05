package natureblossom.ims.controller;


import java.io.IOException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import natureblossom.ims.entity.Product;
import natureblossom.ims.service.ImageUploadService;
import natureblossom.ims.service.ProductService;

/** Controller for product update page.
 *
 * @author R.Yazaki
 * @version 1.0.0
 */
@Controller
public class ProductUpdateController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ImageUploadService imgUploadService;
	
	@Value("${aws.endpoint.url}")
	private String endpoint;
	
	/**
	 * Display product update page.
	 *
	 * @param  
	 * @param  
	 * @return product update page
	 */
	@GetMapping("/product-update")
	public String getUpdateProduct(Model model,
			@RequestParam("id") int id) {
		Product product = productService.getProduct(id);
		model.addAttribute("product", product);
		System.out.println(product.getFilePath());
		model.addAttribute("awsUrl", endpoint);
		return "product-update";
	}
	
	/**
	 * Update product and display product list page.
	 *
	 * @param  
	 * @param  
	 * @return product list page
	 */
	@PostMapping("/product-update")
	public String postUpdateProduct(Model model,
			@ModelAttribute @Valid Product product,
			BindingResult bindingResult) throws IOException {	
		if (bindingResult.hasErrors()) {
			return "product-update";
		}
		
		// if image has been added, upload it to S3 bucket
		if(!Objects.isNull(product.getMultipartFile())) {
			String fileName = product.getMultipartFile().getOriginalFilename();
			String filePath = imgUploadService.uploadImg(
					product.getMultipartFile(), product.getCategory(), fileName);		
			product.setFilePath(filePath);
		}
		
		int returnVal = productService.updateProduct(product);
		System.out.println(returnVal);
//	    if (returnVal == 0) {
//	    	// display error message
//	    }
		return "redirect:/product-list";
	}
}