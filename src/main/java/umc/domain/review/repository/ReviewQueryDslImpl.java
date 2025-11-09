package umc.domain.review.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import umc.domain.review.entity.QReview;
import umc.domain.review.entity.Review;
import umc.domain.store.entity.QStore;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ReviewQueryDslImpl implements ReviewQueryDsl {
    private final EntityManager em;

    @Override
    public Page<Review> searchReview(
            Predicate predicate, Pageable pageable
    ){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        QReview review = QReview.review;
        QStore store = QStore.store;

        //content 쿼리
        List<Review> results = queryFactory
                .selectFrom(review)
                .join(review.store, store).fetchJoin()
                .where(predicate)
                .orderBy(review.createdAt.desc())
                .offset(pageable.getOffset())      // 시작 위치
                .limit(pageable.getPageSize())     // 한 페이지 크기
                .fetch();
        //count 쿼리(페이징 계산용), fetch join 때문에 커스텀 페이지네이션으로 실행
        Long total = Optional.ofNullable(
                queryFactory
                        .select(review.count())
                        .from(review)
                        .where(predicate)
                        .fetchOne()
        ).orElse(0L);

        return new PageImpl<>(results, pageable, total);
    }
}
