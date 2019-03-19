package training.endava.app.DTOMapper;

import training.endava.app.domain.hibernateObjects.PersonInfo;
import training.endava.app.domain.hibernateObjects.PhoneNumber;

import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class PersonInfoDTO{
    private String name;
    private Date birthday;
    private String birthplace;
    private AddressInfoDTO address_info;
    private List<PhoneNumberDTO> phone_numbers;

    public PersonInfoDTO(@NotBlank String name, Date birthday, String birthplace, AddressInfoDTO address_info, List<PhoneNumberDTO> phone_numbers) {
        this.name = name;
        this.birthday = birthday;
        this.birthplace = birthplace;
        this.address_info = address_info;
        this.phone_numbers = phone_numbers;
    }

    public PersonInfoDTO() {

    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressInfoDTO getAddress_info() {
        return address_info;
    }

    public void setAddress_info(AddressInfoDTO address_info) {
        this.address_info = address_info;
    }

    public List<PhoneNumberDTO> getPhone_numbers() {
        return phone_numbers;
    }

    public void setPhone_numbers(List<PhoneNumberDTO> phone_numbers) {
        this.phone_numbers = phone_numbers;
    }

    public PersonInfo toPersonInfo() {
        List<PhoneNumber> list = new ArrayList<>();
        for (PhoneNumberDTO x :
                this.phone_numbers) {
            list.add(x.toPhoneNumber());
        }

        return new PersonInfo(
                this.getName(),
                this.getBirthday(),
                this.getBirthplace(),
                this.getAddress_info().toAddressInfo(),
                list
        );
    }
}
