package training.endava.app.Hibernate.domainHibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorValue("L")
public class LegalPerson extends PersonH implements Serializable {


    @Transient
    private String bankAccount;

    public LegalPerson() {
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }
}
