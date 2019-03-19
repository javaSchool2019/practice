package training.endava.app.Hibernate.domainHibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="LegalPerson")
@DiscriminatorValue("L")
public class LegalPerson extends PersonH implements Serializable {


    @Transient
  //  @Column(name="bankAccount")
    private String bankAccount;
    public LegalPerson(){}

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }
}
