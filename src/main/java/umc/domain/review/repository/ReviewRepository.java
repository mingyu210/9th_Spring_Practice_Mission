package umc.domain.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.domain.review.entity.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByStoreName(String storeName);
}
