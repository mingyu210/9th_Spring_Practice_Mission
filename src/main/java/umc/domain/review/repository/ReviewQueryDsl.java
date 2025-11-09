package umc.domain.review.repository;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.domain.review.entity.Review;


public interface ReviewQueryDsl {

    Page<Review> searchReview(
            Predicate predicate, Pageable pageable
    );
}
