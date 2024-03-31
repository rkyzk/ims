package natureblossom.ims.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import natureblossom.ims.validation.FileTypeValidator;

/**
 * Validate file type
 *
 * @author R.Yazaki
 * @version 1.0.0
 */
@Constraint(validatedBy = FileTypeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FileType {

	/**
	 * Generate error messages
	 *
	 * @return error messages
	 */
	String message() default "{EMSG102}";

	/**
	 * Apply different validations depending on the group
	 *
	 * @return default group
	 */
	Class<?>[] groups() default {};

	/**
	 * チェック対象のオブジェクトにメタ情報を与えるための宣言.
	 *
	 * @return チェック対象オブジェクトのメタ情報
	 */
	Class<? extends Payload>[] payload() default {};
}