package trade.model;

public class CarbonCredit {

    private String creditId;
    private String projectId;
    private double quantity;
    private double price;
    private int vintage;
    private String status;

    public CarbonCredit(
            String creditId,
            String projectId,
            double quantity,
            double price,
            int vintage,
            String status) {

        this.creditId = creditId;
        this.projectId = projectId;
        this.quantity = quantity;
        this.price = price;
        this.vintage = vintage;
        this.status = status;
    }

    public String getCreditId() {
        return creditId;
    }

    public String getProjectId() {
        return projectId;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getVintage() {
        return vintage;
    }

    public String getStatus() {
        return status;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
