package training.endava.app.JPAContext.JPAdomain;

import javax.persistence.*;

@Entity
@Table(name = "phone_numbers")
public class PhoneNumber {


    @ManyToOne
    @JoinColumn(name = "entityNumber")
    private WorkingEntity workingEntity;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "entity_id")
    private Integer workingEntityId;

    @Column(name = "number")
    private String number;

    @Column(name = "service_provider")
    private String serviceProvider;

    @Transient
    private String prefix = "0040";

    public Integer getId() {
        return id;
    }

    public Integer getWorkingEntityId() {
        return workingEntityId;
    }

    public void setWorkingEntityId(Integer workingEntityId) {
        this.workingEntityId = workingEntityId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
