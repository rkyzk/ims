package natureblossom.ims.forms;


import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import natureblossom.ims.annotation.FileName;

/**
 * Form class for image file.
 *
 * @author R.Yazaki
 * @version 1.0.0
 */
@Data
public class ImageForm {
	/** image file name */
	@FileName(maxLength = 15)
	private MultipartFile multipartFile;
}