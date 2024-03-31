package natureblossom.ims.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/** Controller for product registration page.
 *
 * @author R.Yazaki
 * @version 1.0.0
 */
@Controller
public class ProductListController {
	
	/**
	 * Display product list page.
	 *
	 * @param  
	 * @param  
	 * @return product registration page
	 */
	@GetMapping("/product-list")
	public String getProductList() {
		return "product-list";
	}
}