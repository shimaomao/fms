package cn.com.leadu.fms.product.validator.finitem.validator;

import cn.com.leadu.fms.product.service.FinItemService;
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
 * @author huchenghao
 * @ClassName: FinItemValidator
 * @Description:
 * @date 2018/4/4.
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy= FinItemValidator.FinItemValidatorImpl.class)
public @interface FinItemValidator {

    String value() default "";

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class FinItemValidatorImpl implements ConstraintValidator<FinItemValidator,String> {

        @Autowired
        private FinItemService finItemService;

        @Override
        public void initialize(FinItemValidator finitemValidator) {

        }

        @Override
        public boolean isValid(String finItem, ConstraintValidatorContext constraintValidatorContext) {
            return finItemService.findFinItemByFinItem(finItem) == null;
        }

    }
}
