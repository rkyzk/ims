package natureblossom.ims.entity;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

/**
 * Build object 'Product' for JUnit tests
 * 
 * @author Reiko Yazaki
 * @version 1.0
 */
public class ProductBuilder {
	/** Product ID */
	private int id;

	/** Product name */
	private String name;

	/** Category */
	private String category;
	
	/** Manufacturer */
	private String manufacturer;

	/** Quantity per package */
	private int quantity;
	
	/** Price */
	private BigDecimal price;
	
	/** Stock */
	private int stock;

	/** Description */
	private String description;

	/** image file path */
	private String filePath;
	
	/** image file name */
	private String fileName;

	/** image file (not to be inserted in DB) */
	private MultipartFile multipartFile;


    public ProductBuilder() {
        id = 1;
        name = "test";
        category = "tulips";
        manufacturer = "test";
        quantity = 1;
        price = new BigDecimal("10.55");     
    }

    public ProductBuilder withId(final int id) {
        this.id = id;
        return this;
    }
    
    public ProductBuilder withName(final String name) {
        this.name = name;
        return this;
    }
    
    public ProductBuilder withCategory(final String category) {
        this.category = category;
        return this;
    }
  
    public ProductBuilder withManufacturer(final String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }
    
    public ProductBuilder withQuantity(final int quantity) {
        this.quantity = quantity;
        return this;
    }
    
    public ProductBuilder withPrice(final BigDecimal price) {
        this.price = price;
        return this;
    }
    
    public ProductBuilder withStock(final int stock) {
        this.stock = stock;
        return this;
    }
    
    public ProductBuilder withDescription(final String description) {
        this.description = description;
        return this;
    }
    
    public ProductBuilder withFilePath(final String filePath) {
        this.filePath = filePath;
        return this;
    }
    
    public ProductBuilder withFileName(final String fileName) {
        this.fileName = fileName;
        return this;
    }    

    public ProductBuilder withMultipartFile(final MultipartFile file) {
        this.multipartFile = file;
        return this;
    }

    public Product build() {
        final Product product = new Product();
        return product;
    }
}
