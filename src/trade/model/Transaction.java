package trade.model;

import java.time.LocalDateTime;

public class Transaction {

    private String transactionId;
    private String buyerId;
    private String sellerId;
    private String creditId;
    private double quantity;
    private double totalAmount;
    private LocalDateTime date;

    public Transaction(
            String transactionId,
            String buyerId,
            String sellerId,
            String creditId,
            double quantity,
            double totalAmount) {

        this.transactionId = transactionId;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.creditId = creditId;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.date = LocalDateTime.now();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public String getCreditId() {
        return creditId;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
