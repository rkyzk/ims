package natureblossom.ims.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import natureblossom.ims.entity.Product;
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
		model.addAttribute("awsUrl", endpoint);
		return "product-update";
	}
}