package training.endava.app.domain.hibernateObjects;


import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "persons")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "entry_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("notOk")
public class PageEntry {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @NonNull
    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private AddressInfo address_info;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PhoneNumber> phone_numbers;

    public PageEntry(String name, AddressInfo addressInfo, List<PhoneNumber> phoneNumberList) {
        this.name = name;
        this.address_info = addressInfo;
        this.phone_numbers = phoneNumberList;
    }

    public PageEntry(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressInfo getAddressInfo() {
        return address_info;
    }

    public void setAddressInfo(AddressInfo addressInfo) {
        this.address_info = addressInfo;
    }

    public List<PhoneNumber> getPhoneNumberList() {
        return phone_numbers;
    }

    public void setPhoneNumberList(List<PhoneNumber> phoneNumberList) {
        this.phone_numbers = phoneNumberList;
    }
}
