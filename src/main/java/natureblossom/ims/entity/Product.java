package natureblossom.ims.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import natureblossom.ims.annotation.FileName;
import natureblossom.ims.annotation.FileSize;
import natureblossom.ims.annotation.FileType;
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

	/** Quantity */
	@Min(1)
	@Max(999)
	@NotNull
	private int quantity;
	
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

	/** image file path */
	private String filePath;
	
	/** image file name */
	private String fileName;

	/** image file (not to be inserted in DB) */
	@FileType
	@FileSize(maxSize = 819200)
	@FileName(maxLength = 30)
	private MultipartFile multipartFile;

	/** created at */
	private LocalDateTime createdAt;

	/** updated at */
	private LocalDateTime updatedAt;

	/** delete flag */
	private char delFlg;
}