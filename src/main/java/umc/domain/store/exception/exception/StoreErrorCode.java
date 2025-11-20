package umc.domain.store.exception.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.global.apiPayload.code.BaseErrorCode;

@Getter
@AllArgsConstructor
public enum StoreErrorCode implements BaseErrorCode {

    REGION_NOT_FOUND(HttpStatus.NOT_FOUND, "STORE_404_1", "해당 지역을 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
