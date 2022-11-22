package vn.edu.iuh.fit.se.thubonggiareapis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.thubonggiareapis.converter.PromotionConverter;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.PromotionDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Promotion;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.User;
import vn.edu.iuh.fit.se.thubonggiareapis.repository.PromotionRepository;
import vn.edu.iuh.fit.se.thubonggiareapis.repository.UserRepository;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IPromotionService;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class PromotionServiceImpl implements IPromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PromotionConverter promotionConverter;

    @Override
    public PromotionDTO addPromotion(PromotionDTO promotionDTO) {
        Promotion promotion = promotionConverter.toEntity(promotionDTO);
        User user = userRepository.getById(promotionDTO.getCreatedBy());
        promotion.setCreatedBy(user);
        promotionRepository.save(promotion);
        return promotionConverter.toDto(promotion);
    }

    @Override
    public PromotionDTO getPromotion(long id) {
        Promotion promotion = promotionRepository.getById(id);
        return promotionConverter.toDto(promotion);
    }

    @Override
    public void updatePromotion(PromotionDTO promotionDTO) {
        // TODO Auto-generated method stub
        Promotion promotion = promotionConverter.toEntity(promotionDTO);
        User user = userRepository.getById(promotionDTO.getCreatedBy());
        promotion.setCreatedBy(user);
        System.out.println("entity:" + promotion);
        promotionRepository.save(promotion);
    }

    @Override
    public PromotionDTO getPromotionByCode(String promotionCode) {
        Promotion promotion = promotionRepository.findByPromotionCode(promotionCode);
        if (Objects.isNull(promotion)) {
            return null;
        }
        return promotionConverter.toDto(promotion);
    }

    @Override
    public List<PromotionDTO> getAllPromotions() {
        List<Promotion> promotions = promotionRepository.findAll();
        return promotionConverter.toDtos(promotions);
    }

    @Override
    public long getExpiredPromotions() {
        Long expiredByDate =  promotionRepository.countPromotionsByExpiredDateIsLessThanEqual(LocalDateTime.now());
        Long expiredByLimit = promotionRepository.countPromotionsByLimitEquals(0);
        return expiredByDate + expiredByLimit;
    }

    @Override
    public long getTotalPromotion() {
        return promotionRepository.count();
    }

    @Override
    public List<PromotionDTO> getAllPromotionByExpiredDate(LocalDateTime now) {
        return promotionConverter.toDtos(promotionRepository.findPromotionByExpiredDateIsLessThanEqual(now));
    }

    @Override
    public List<PromotionDTO> getAllPromotionExpiredByLimit() {
        return promotionConverter.toDtos(
                promotionRepository.findPromotionByLimitEquals(0)
        );
    }

    @Override
    public List<PromotionDTO> getAllPromotionInDueDate() {
        List<PromotionDTO> expiredPromotions = getAllPromotionByExpiredDate(LocalDateTime.now());
        expiredPromotions.addAll(getAllPromotionExpiredByLimit());
        if (expiredPromotions.size() > 0) {
            Set<PromotionDTO> setOfExpiredPromotions = new HashSet<>(expiredPromotions);
            List<Long> ids = new ArrayList<>();
            setOfExpiredPromotions.forEach(expiredPromotion -> {
                ids.add(expiredPromotion.getId());
            });
            return promotionConverter.toDtos(promotionRepository.findPromotionsByIdNotIn(ids));
        }
        return getAllPromotions();
    }
}
