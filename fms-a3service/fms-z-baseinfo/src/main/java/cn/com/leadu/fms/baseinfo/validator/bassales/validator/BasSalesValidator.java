package cn.com.leadu.fms.baseinfo.validator.bassales.validator;

import cn.com.leadu.fms.baseinfo.service.BasSalesService;
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
 * Created by 65604 on 2018/5/31.
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=BasSalesValidator.BasSalesValidatorImpl.class)
public @interface BasSalesValidator {
    String value() default "";

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class BasSalesValidatorImpl implements ConstraintValidator<BasSalesValidator,String> {

        @Autowired
        private BasSalesService basSalesService;

        @Override
        public void initialize(BasSalesValidator basSalesValidator) {

        }

        @Override
        public boolean isValid(String salesCode, ConstraintValidatorContext constraintValidatorContext) {
            return basSalesService.findBasSalesBySalesCode(salesCode) == null;
        }

    }
}
