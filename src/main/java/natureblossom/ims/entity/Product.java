package natureblossom.ims.entity;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Entity class for 'Product' model.
 *
 * @author R.Yazaki
 * @version 1.0.0
 */
@Data
public class Product {
	/** Product ID */
	private int id;
	
	/** Product name */
	@NotBlank
	@Size(max = 40)
	private String name;

	/** Category */
	private String category;	
	
	/** Manufacturer */
	@NotBlank
	@Size(max = 30)
	private String manufacturer;

	/** Price */
	@NotNull
	@DecimalMin(value = "0.00", inclusive = true)
	@Digits(integer=5, fraction=2)
	private BigDecimal price;
	
	/** Stock */
	@Min(0)
	@Max(99999)
	private int stock;

	/** Description */
	@Size(max = 200)
	private String description;

	/** image file name*/
	private String filePath;

	/** created at */
	private String createdAt;

	/** updated at */
	private String updatedAt;

	/** delete flag */
	private char delFlg;
}