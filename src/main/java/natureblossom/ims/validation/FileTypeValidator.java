package natureblossom.ims.validation;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import natureblossom.ims.annotation.FileType;

/**
 * Generate file type.
 *
 * @author R.Yazaki
 * @version 1.0.0
 */
public class FileTypeValidator implements ConstraintValidator<FileType, MultipartFile> {
	/**
	 * Check if the file is jpeg or png.
	 *
	 * @param value: image file
	 * @param context 
	 * @return If the file doesn't exist, or the type is jpeg or png, return true,
	 *         otherwise false.
	 */
	@Override
	public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {
		return (value.isEmpty() || value.getContentType().equals("image/png") || 
				value.getContentType().equals("image/jpeg") || 
				value.getContentType().equals("image/jpg"));
	}
}