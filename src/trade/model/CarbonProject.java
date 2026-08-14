package trade.model;

public class CarbonProject {

    private String projectId;
    private String sellerId;
    private String name;
    private String location;
    private String description;
    private String verificationStatus;

    public CarbonProject(
            String projectId,
            String sellerId,
            String name,
            String location,
            String description,
            String verificationStatus) {

        this.projectId = projectId;
        this.sellerId = sellerId;
        this.name = name;
        this.location = location;
        this.description = description;
        this.verificationStatus = verificationStatus;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }
}