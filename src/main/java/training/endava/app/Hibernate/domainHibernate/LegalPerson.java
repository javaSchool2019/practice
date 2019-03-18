package training.endava.app.Hibernate.domainHibernate;

import javax.persistence.*;

@Entity
@Table(name="LegalPerson")
@DiscriminatorValue("L")
public class LegalPerson extends PersonH {


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
