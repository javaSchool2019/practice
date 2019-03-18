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

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Company extends training.endava.app.domain.entity.Entity {
    private String businessName;
    private String activityDomain;
    private Long operatingHours;

}

