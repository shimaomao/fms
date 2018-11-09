package cn.com.leadu.fms.system.validator.systpl.validator;

import cn.com.leadu.fms.system.service.SysTplService;
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
 * @ClassName: SysTplSaveValidator
 * @Description:
 * @date 2018/3/15.
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=SysTplSaveValidator.SysTplSaveValidatorImpl.class)
public @interface SysTplSaveValidator {

    String value() default "";

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class SysTplSaveValidatorImpl implements ConstraintValidator<SysTplSaveValidator,String> {

        @Autowired
        private SysTplService sysTplService;

        @Override
        public void initialize(SysTplSaveValidator sysTplTypeSaveValidator) {

        }

        @Override
        public boolean isValid(String tplName, ConstraintValidatorContext constraintValidatorContext) {
            return sysTplService.findSysTplByTplName(tplName) == null;
        }

    }
}
