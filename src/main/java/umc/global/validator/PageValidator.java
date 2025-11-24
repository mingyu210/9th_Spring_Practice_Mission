package umc.global.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import umc.global.annotation.ValidPage;

public class PageValidator implements ConstraintValidator<ValidPage, Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        // null이면 다른 validation에서 처리 or defaultValue로 들어온 경우 허용
        if (value == null) {
            return true;
        }

        // page는 반드시 1 이상이어야 함
        return value >= 1;
    }
}
