package vn.edu.iuh.fit.se.thubonggiareapis.service;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.PromotionDTO;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface IPromotionService {
    PromotionDTO addPromotion(PromotionDTO promotionDTO);

    PromotionDTO getPromotion(long id);

    void updatePromotion(PromotionDTO promotionDTO);

    PromotionDTO getPromotionByCode(String promotionCode);

    List<PromotionDTO> getAllPromotions();

    long getExpiredPromotions();

    long getTotalPromotion();

    List<PromotionDTO> getAllPromotionByExpiredDate(LocalDateTime expiredDate);

    List<PromotionDTO> getAllPromotionExpiredByLimit();

    List<PromotionDTO> getAllPromotionInDueDate();
}
