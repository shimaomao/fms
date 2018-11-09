package cn.com.leadu.fms.product.validator.productcatg.validator;

import cn.com.leadu.fms.product.service.FinItemService;
import cn.com.leadu.fms.product.service.ProductCatgService;
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
@Constraint(validatedBy= ProductCatgValidator.ProductCatgValidatorValidatorImpl.class)
public @interface ProductCatgValidator {

    String value() default "";

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class ProductCatgValidatorValidatorImpl implements ConstraintValidator<ProductCatgValidator,String> {

        @Autowired
        private ProductCatgService productCatgService;

        @Override
        public void initialize(ProductCatgValidator productCatgValidator) {

        }

        @Override
        public boolean isValid(String productCatg, ConstraintValidatorContext constraintValidatorContext) {
            return productCatgService.findProductCatgByProductCatg(productCatg) == null;
        }

    }
}
