package sys.spvision.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import sys.spvision.core.validator.MobileValidator;

/**
 * 自定义支持JSR303规范的校验注解
 * @author yongli.yang
 *
 */

@Target(value={ElementType.METHOD,ElementType.FIELD,java.lang.annotation.ElementType.ANNOTATION_TYPE, 
		java.lang.annotation.ElementType.CONSTRUCTOR, java.lang.annotation.ElementType.PARAMETER}) 
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=MobileValidator.class)
public @interface Mobile {
	
	public String message() default "手机号码错误。";
	public Class<?>[] groups()default{}; 
	public Class<? extends Payload>[] payload()default{};
}
