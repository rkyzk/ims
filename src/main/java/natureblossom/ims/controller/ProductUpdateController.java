package natureblossom.ims.controller;


import java.io.IOException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@Autowired
	private MessageSource msg;
	
	@Value("${aws.endpoint.url}")
	private String endpoint;
	
	/**
	 * Display product update page.
	 *
	 * @param model
	 * @param id
	 * @return product update page
	 */
	@GetMapping("/product-update")
	public String getUpdateProduct(Model model,
			@RequestParam("id") int id) {
		Product product = productService.getProduct(id);
		model.addAttribute("product", product);
		model.addAttribute("awsUrl", endpoint);
		return "product-update";
	}
	
	/**
	 * Update product and display product list page.
	 *
	 * @param model 
	 * @param locale
	 * @param currImg
	 * @param redirectAttributes
	 * @param product
	 * @param bidingResult 
	 * @return product list page
	 */
	@PostMapping("/product-update")
	public String updateProduct(Model model, Locale locale,
			@RequestParam(name="curr-img", required=false) boolean currImg,
			RedirectAttributes redirectAttributes,
			@ModelAttribute @Valid Product product,
			BindingResult bindingResult) throws IOException {
        // if there're validation errors, show update page again.
		if (bindingResult.hasErrors()) {
			return "product-update";
		}
		
		/** If image has been removed, delete the image from AWS storage
		 *  and set filePath & fileName empty string.
		 */
		imgUploadService.deleteImg(product.getFilePath());
		if (currImg) {
			product.setFilePath("");
			product.setFileName("");
		}	
		// if image has been added, upload it to S3 bucket
		if(!product.getMultipartFile().isEmpty()) {
			String fileName = product.getMultipartFile().getOriginalFilename();
			product.setFileName(fileName);
			String filePath = imgUploadService.uploadImg(
					product.getMultipartFile(), product.getCategory(), fileName);		
			product.setFilePath(filePath);
		}

		int returnVal = productService.updateProduct(product);
	    if (returnVal == 1) {
	    	// set success message to display on the list controller
	    	redirectAttributes.addFlashAttribute(
	    			"message", msg.getMessage("UPDSUC", null, locale));
	    } else {
	    	// set error message
	    	redirectAttributes.addFlashAttribute(
	    			"message", msg.getMessage("UPDERR", null, locale));
	    }
		return "redirect:/product-list";
	}
}