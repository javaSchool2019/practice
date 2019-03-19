package training.endava.app.payload.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import training.endava.app.domain.entity.Company;
import training.endava.app.domain.entity.Person;
import training.endava.app.payload.CompanyDTO;
import training.endava.app.payload.PersonDTO;


@Mapper
public interface CompanyMapper {

    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);
    @Mappings({
            @Mapping(target="businessName", source="entity.businessName"),
            @Mapping(target = "activityDomain", source = "entity.activityDomain"),
            @Mapping(target = "operatingHours", source = "entity.operatingHours"),
            @Mapping(target = "phoneNumbers", source = "entity.phoneNumbers"),
            @Mapping(target = "address", source = "entity.address")
    })
    CompanyDTO companyToCompanyDTO(Company entity);
}
