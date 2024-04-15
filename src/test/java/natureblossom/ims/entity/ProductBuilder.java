package natureblossom.ims.entity;

import java.math.BigDecimal;

public class ProductBuilder {

	/** product */
	private Product product = new Product();

	/**
	 * 
	 * Return product object for tests.
	 * 
	 * @return product
	 */
	public Product buildProduct() {
		this.product.setName("test");
		this.product.setCategory("tulips");
		this.product.setManufacturer("test");
		this.product.setQuantity(3);
		this.product.setPrice(new BigDecimal("10.51"));
		return this.product;	
	}
}