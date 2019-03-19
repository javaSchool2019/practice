package training.endava.app.domain;


import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
@Table(name = "yellow_page_entry")
@DiscriminatorValue("C")
public class Company extends YellowPageEntry implements Serializable{

    @Column(name = "business_name", length = 50)
    private String businessName;

    @Column(name = "activity_domain", length = 20)
    private String activityDomain;

    @Column(name = "operating_hours", length = 10)
    @Pattern(regexp = "(\\d){2}:(\\d){2}-(\\d){2}:(\\d){2}")
    private String operatingHours;
}
