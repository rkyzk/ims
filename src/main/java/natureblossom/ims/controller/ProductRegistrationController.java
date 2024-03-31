package natureblossom.ims.controller;

import java.io.IOException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import natureblossom.ims.entity.Product;
import natureblossom.ims.service.ImageUploadService;
import natureblossom.ims.service.ProductService;

/** Controller for product registration page.
 *
 * @author R.Yazaki
 * @version 1.0.0
 */
@Controller
public class ProductRegistrationController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ImageUploadService imgUploadService;	
	
	/**
	 * Display product registration page.
	 *
	 * @param  model
	 * @param  product
	 * @return product registration page
	 */
	@GetMapping("/product-registration")
	public String getProductRegistration(Model model,
			@ModelAttribute("product") Product product) {
		return "product-registration";
	}
	
	/**
	 * Insert product data in DB.
	 *
	 * @param model
	 * @param redirectAttributes
	 * @param product
	 * @param bindingResult
	 */
	@PostMapping("/product-registration")
	public String postProduct(Model model, RedirectAttributes redirectAttributes,
			@ModelAttribute("product") @Valid Product product,
			BindingResult bindingResult) throws IOException {
		
		// if there're validation errors, display register product page again.
		if (bindingResult.hasErrors()) {
			return "product-registration";
		}
		
		// if image has been added, upload it to S3 bucket
		if(!Objects.isNull(product.getMultipartFile())) {
			String fileName = product.getMultipartFile().getOriginalFilename();
			String filePath = imgUploadService.uploadImg(
					product.getMultipartFile(), product.getCategory(), fileName);		
			product.setFilePath(filePath);
		}
		// insert product in DB
		productService.insertProduct(product);	
		// redirect to product list page.
		return "redirect:/product-list";
	}
}