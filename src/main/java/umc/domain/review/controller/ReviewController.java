package umc.domain.review.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.domain.review.dto.ReviewResponseDTO;
import umc.domain.review.entity.Review;
import umc.domain.review.service.ReviewQueryService;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewQueryService reviewQueryService;

    @GetMapping("/reviews/search")
    public ResponseEntity<List<ReviewResponseDTO>> searchReview(
            @RequestParam Long memberId,              // ✅ 추가됨
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String query
    ){
        List<ReviewResponseDTO> result = reviewQueryService.searchReview(memberId, type, query);
        return ResponseEntity.ok(result);
    }
}
