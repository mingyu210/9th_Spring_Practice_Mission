package umc.domain.review.dto.req;

public class ReviewReqDTO {

    public record CreateReviewDTO(
            Long memberId,
            Integer grade,
            String content,
            Long storeId
    ){}
}
