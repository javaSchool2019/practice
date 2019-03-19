package training.endava.app.domain.entity;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "COMPANY")
@DiscriminatorValue("C")

@NamedQueries({
        @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c")
})

public class Company extends training.endava.app.domain.entity.Entity {
    private String businessName;
    private String activityDomain;
    private Long operatingHours;

    @Override
    public String toString() {
        return "Company{" +
                "businessName='" + businessName + '\'' +
                ", activityDomain='" + activityDomain + '\'' +
                ", operatingHours=" + operatingHours +
                '}';
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getActivityDomain() {
        return activityDomain;
    }

    public void setActivityDomain(String activityDomain) {
        this.activityDomain = activityDomain;
    }

    public Long getOperatingHours() {
        return operatingHours;
    }

    public void setOperatingHours(Long operatingHours) {
        this.operatingHours = operatingHours;
    }
}

