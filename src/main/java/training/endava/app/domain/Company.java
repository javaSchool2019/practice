package training.endava.app.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Company extends YellowPageEntry {
    @Column(name = "company_name")
    private String companyName;

    @Column(name = "activity_domain")
    private String activityDomain;

    @Column(name = "operating_hours")
    private String operatingHours;
}
