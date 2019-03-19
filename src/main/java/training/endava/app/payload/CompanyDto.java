package training.endava.app.payload;

import lombok.Data;
import lombok.NoArgsConstructor;
import training.endava.app.domain.Company;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class CompanyDto {
    @NotBlank
    private String companyName;

    @NotBlank
    private String activityDomain;

    private String operatingHours;

    @NotNull
    private AddressDto address;

    private List<PhoneNumberDto> phoneNumberList;

    public Company toCompany() {
        Company company = new Company();
        company.setCompanyName(getCompanyName());
        company.setActivityDomain(getActivityDomain());
        company.setOperatingHours(getOperatingHours());
        company.setAddress(address.toAddress());
        company.setPhoneNumbers(phoneNumberList.stream()
                .map(PhoneNumberDto::toPhoneNumber)
                .collect(Collectors.toList()));
        return company;
    }
}
