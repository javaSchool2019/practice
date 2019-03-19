package training.endava.app.JPAContext.JPAdomain;

import javax.persistence.*;

@Embeddable
@Table(name= "entities")
@DiscriminatorValue("companies")
public class Company {

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "activity_domain")
    private String activityDomain;

    @Column(name = "operating_hours")
    private String operatingHours;

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

    public String getOperatingHours() {
        return operatingHours;
    }

    public void setOperatingHours(String operatingHours) {
        this.operatingHours = operatingHours;
    }
}
