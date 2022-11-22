package vn.edu.iuh.fit.se.thubonggiareapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Promotion;

import java.time.LocalDateTime;
import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    Promotion findByPromotionCode(String promotionCode);

    Long countPromotionsByExpiredDateIsLessThanEqual(LocalDateTime expiredDate);

    Long countPromotionsByLimitEquals(int limit);

    List<Promotion> findPromotionByExpiredDateIsLessThanEqual(LocalDateTime expireDate);

    List<Promotion> findPromotionByLimitEquals(int limit);

    List<Promotion> findPromotionsByIdNotIn(List<Long> ids);
}
