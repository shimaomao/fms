package cn.com.leadu.fms.system.validator.systpltype.validator;

import cn.com.leadu.fms.system.service.SysTplTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wangxue
 * @ClassName: SysTplTypeSaveValidator
 * @Description:
 * @date 2018/3/15.
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=SysTplTypeSaveValidator.SysTplTypeSaveValidatorImpl.class)
public @interface SysTplTypeSaveValidator {

    String value() default "";

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class SysTplTypeSaveValidatorImpl implements ConstraintValidator<SysTplTypeSaveValidator,String> {

        @Autowired
        private SysTplTypeService sysTplTypeService;

        @Override
        public void initialize(SysTplTypeSaveValidator sysTplTypeSaveValidator) {

        }

        @Override
        public boolean isValid(String tplTypeKey, ConstraintValidatorContext constraintValidatorContext) {
            return sysTplTypeService.findSysTplTypeByTplTypeKey(tplTypeKey) == null;
        }

    }

}
