package natureblossom.ims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import natureblossom.ims.entity.Product;
import natureblossom.ims.service.ProductService;

/** Controller for product registration page.
 *
 * @author R.Yazaki
 * @version 1.0.0
 */
@Controller
public class ProductListController {

	@Autowired
	private ProductService productService;
	
	@Value("${aws.endpoint.url}")
	private String endpoint;
	
	/**
	 * Display product list page.
	 *
	 * @param  
	 * @param  
	 * @return product list page
	 */
	@GetMapping("/product-list")
	public String getProductList(Model model) {
		List<Product> prodList = productService.getProductList();	
		model.addAttribute("prodList", prodList);
		model.addAttribute("itemCount", prodList.size());
		model.addAttribute("awsUrl", endpoint);
		return "product-list";
	}
	
	@PostMapping("/delete")
	public String delete(Model model) {
		int returnVal = productService.deleteProduct();	
		return "redirect:/product-list";
	}
}