package umc.domain.review.dto.req;

import umc.global.annotation.ExistStore;

public class ReviewReqDTO {

    public record CreateReviewDTO(
            Long memberId,
            Integer grade,
            String content,
            @ExistStore
            Long storeId
    ){}
}
