package natureblossom.ims.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/** Controller for product registration page.
 *
 * @author R.Yazaki
 * @version 1.0.0
 */
@Controller
public class ProductRegistrationController {
	/**
	 * Display product registration page.
	 *
	 * @param  model
	 * @param  product
	 * @return product registration page
	 */
	@GetMapping("/product-registration")
	public String getProductRegistration(Model model) {
		return "product-registration";
	}
	
}