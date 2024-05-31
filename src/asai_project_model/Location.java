package asai_project_model;

import java.util.Date;

public class Location {
    private String codeLocation;
    private String descLocation;
    private Date createdAt;

    public Location(String codeLocation, String descLocation, Date createdAt) {
        this.codeLocation = codeLocation;
        this.descLocation = descLocation;
        this.createdAt = createdAt;
    }

    public String getCodeLocation() {
        return codeLocation;
    }

    public void setCodeLocation(String codeLocation) {
        this.codeLocation = codeLocation;
    }

    public String getDescLocation() {
        return descLocation;
    }

    public void setDescLocation(String descLocation) {
        this.descLocation = descLocation;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Location{" +
                "codeLocation='" + codeLocation + '\'' +
                ", descLocation='" + descLocation + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
