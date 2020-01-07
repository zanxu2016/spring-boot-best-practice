package info.luckydog.springboot.paramvalid.validator;

import info.luckydog.springboot.paramvalid.annotation.IdCard;
import info.luckydog.springboot.paramvalid.util.IdCardUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * IdCardValidator
 *
 * @author eric
 * @since 2020/1/6
 */
public class IdCardValidator implements ConstraintValidator<IdCard, Object> {
    @Override
    public void initialize(IdCard constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }

    private static boolean is18ByteIdCardComplex(String idNo) {
        return IdCardUtil.checkIDNo(idNo);
    }
}
