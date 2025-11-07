package umc.domain.review.service;

import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.domain.review.entity.QReview;
import umc.domain.review.entity.Review;
import umc.domain.review.repository.ReviewRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewQueryService {

    private final ReviewRepository reviewRepository;

    public List<Review> searchReview(Long member, String type, String query){
        QReview review = QReview.review;
        BooleanBuilder builder = new BooleanBuilder();

        // 내가 작성한 리뷰만 조회
        builder.and(review.member.id.eq(member));


        if(type != null && query != null){
            if(type.equals("store")){
                builder.and(review.store.name.containsIgnoreCase(query));
            }
            else if(type.equals("grade")){
                try {
                    int gradeGroup = Integer.parseInt(query);
                    builder.and(review.grade.eq(gradeGroup));
                } catch (NumberFormatException e){
                    // query가 숫자가 아니면 무시
                }
            }
            else if(type.equals("both")){
                String[] queries = query.split("&");
                if(queries.length == 2){
                    String storeName = queries[0];
                    try {
                        int gradeGroup = Integer.parseInt(queries[1]);
                        builder.and(review.store.name.containsIgnoreCase(storeName));
                        builder.and(review.grade.eq(gradeGroup));
                    } catch (NumberFormatException e){
                        builder.and(review.store.name.containsIgnoreCase(storeName));
                    }
                }
            }
        }

        return reviewRepository.searchReview(builder);
    }
}
