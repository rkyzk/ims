package natureblossom.ims.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@Autowired
	private MessageSource msg;
	
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
	public String getProductList(Model model, Locale locale,
			RedirectAttributes redirectAttributes) {
		List<Product> prodList = productService.getProductList();	
		model.addAttribute("prodList", prodList);
		model.addAttribute("itemCount", prodList.size());
		model.addAttribute("awsUrl", endpoint);
		return "product-list";
	}
	
	@PostMapping("/delete")
	public String delete(Model model, Locale locale, @RequestParam int id,
			RedirectAttributes redirectAttributes) {
		int returnVal = productService.deleteProduct(id);
		redirectAttributes.addFlashAttribute("message", msg.getMessage("DELSUC", null, locale));
		return "redirect:/product-list";
	}
}