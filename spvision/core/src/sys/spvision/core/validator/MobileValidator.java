package sys.spvision.core.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sys.spvision.core.annotation.Mobile;

/**
 * 自定义支持JSR303规范的校验注解解析器 ，
 *
 * @author yongli.yang
 *
 */

public class MobileValidator implements ConstraintValidator<Mobile,String>{
	
	private static final Logger logger = LoggerFactory.getLogger(MobileValidator.class);
	
	private String mobileReg  = "^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\\d{8})$"; 
    private Pattern mobilePattern = Pattern.compile(mobileReg);
    
	@Override
	public void initialize(Mobile money) {
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext arg1) {
		if(null == value || "".equals(value)){
			return true;
		}
		if(mobilePattern.matcher(value).matches()){
			logger.info("MobileValidator class mobile of entity validate success");
			return true;
		}
		logger.error("MobileValidator class mobile of entity validate failure");
		return false;
	} 

	
}
