package training.endava.app.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY")
@DiscriminatorValue("C")

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

