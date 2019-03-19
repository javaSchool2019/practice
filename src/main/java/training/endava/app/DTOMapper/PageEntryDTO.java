package training.endava.app.DTOMapper;

import org.springframework.lang.NonNull;
import training.endava.app.domain.hibernateObjects.AddressInfo;
import training.endava.app.domain.hibernateObjects.PageEntry;
import training.endava.app.domain.hibernateObjects.PhoneNumber;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class PageEntryDTO {

    private String name;

    private AddressInfoDTO address_info;

    private List<PhoneNumberDTO> phone_numbers;

    public PageEntryDTO(String name, AddressInfoDTO addressInfo, List<PhoneNumberDTO> phoneNumberList) {
        this.name = name;
        this.address_info = addressInfo;
        this.phone_numbers = phoneNumberList;
    }

    public PageEntryDTO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressInfoDTO getAddressInfo() {
        return address_info;
    }

    public void setAddressInfo(AddressInfoDTO addressInfo) {
        this.address_info = addressInfo;
    }

    public List<PhoneNumberDTO> getPhoneNumberList() {
        return phone_numbers;
    }

    public void setPhoneNumberList(List<PhoneNumberDTO> phoneNumberList) {
        this.phone_numbers = phoneNumberList;
    }

    public PageEntry toPageEntry() {
        List<PhoneNumber> list =  new ArrayList<>();
        this.phone_numbers.forEach(x->list.add(x.toPhoneNumber()));
        return new PageEntry(
                this.name,
                this.address_info.toAddressInfo(),
                list
        );
    }
}
