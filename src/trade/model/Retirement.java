package trade.model;

import java.time.LocalDateTime;

public class Retirement {

    private String retirementId;
    private String buyerId;
    private String creditId;
    private double quantity;
    private LocalDateTime date;

    public Retirement(
            String retirementId,
            String buyerId,
            String creditId,
            double quantity) {

        this.retirementId = retirementId;
        this.buyerId = buyerId;
        this.creditId = creditId;
        this.quantity = quantity;
        this.date = LocalDateTime.now();
    }

    public String getRetirementId() {
        return retirementId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public String getCreditId() {
        return creditId;
    }

    public double getQuantity() {
        return quantity;
    }

    public LocalDateTime getDate() {
        return date;
    }
}