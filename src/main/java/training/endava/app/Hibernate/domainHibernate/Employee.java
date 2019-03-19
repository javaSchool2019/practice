package training.endava.app.Hibernate.domainHibernate;

import training.endava.app.Hibernate.domainHibernate.Person;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employeeTable")
@DiscriminatorValue("E")
public class Employee extends Person implements Serializable {

    @Column(name = "eFirstName")
    private String firstName;
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public Employee(){}
    public Employee(String firstName){
        this.firstName = firstName;
    }

    public Employee(Integer id, String name, Integer phoneNumber, Integer addressId, String firstName) {
        super(id, name, phoneNumber, addressId);
        this.firstName = firstName;
    }
}
