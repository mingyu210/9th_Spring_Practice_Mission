package umc.global.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;
import umc.domain.store.code.StoreErrorCode;
import umc.domain.store.repository.StoreRepository;
import umc.global.annotation.ExistStores;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator<ExistStores, List<Long>> {
    private final StoreRepository storeRepository;

    @Override
    public boolean isValid(List<Long> storeIds, ConstraintValidatorContext context) {
        if (storeIds == null || storeIds.isEmpty()) {
            return true; // null이나 empty는 검증 통과
        }

        boolean isValid = storeIds.stream()
                .allMatch(storeId -> storeRepository.existsById(storeId));

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(StoreErrorCode.STORE_NOT_FOUND.getMessage())
                    .addConstraintViolation();
        }

        return isValid;
    }
}
