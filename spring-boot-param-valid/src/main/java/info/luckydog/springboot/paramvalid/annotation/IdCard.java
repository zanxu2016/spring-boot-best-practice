package info.luckydog.springboot.paramvalid.annotation;

import info.luckydog.springboot.paramvalid.validator.IdCardValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * IdCard
 *
 * @author eric
 * @since 2020/1/6
 */
@Documented
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdCardValidator.class)
public @interface IdCard {

    String message() default "身份证号码不合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
