package vn.edu.iuh.fit.se.thubonggiareapis.dto;

import java.time.LocalDateTime;

public class PromotionDTO extends AbstractDTO {
    private double deducted;
    private LocalDateTime expiredDate;
    private int limit;
    private String promotionCode;
    private long createdBy;

    public PromotionDTO() {
        super();
    }

    public PromotionDTO(double deducted, LocalDateTime expiredDate, int limit, String promotionCode, long createdBy) {
        super();
        this.deducted = deducted;
        this.expiredDate = expiredDate;
        this.limit = limit;
        this.promotionCode = promotionCode;
        this.createdBy = createdBy;
    }

    public double getDeducted() {
        return deducted;
    }

    public void setDeducted(double deducted) {
        this.deducted = deducted;
    }

    public LocalDateTime getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDateTime expiredDate) {
        this.expiredDate = expiredDate;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PromotionDTO)) return false;

        PromotionDTO that = (PromotionDTO) o;

        return getPromotionCode().equals(that.getPromotionCode());
    }

    @Override
    public int hashCode() {
        return getPromotionCode().hashCode();
    }

    @Override
    public String toString() {
        return "PromotionDTO [deducted=" + deducted + ", expiredDate=" + expiredDate + ", limit=" + limit
                + ", promotionCode=" + promotionCode + ", createdBy=" + createdBy + "]";
    }


}
