package training.endava.app.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import training.endava.app.domain.Person;
import training.endava.app.filters.PersonDTO;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mappings({
            @Mapping(target="personName", source="person.name"),
            @Mapping(target="personPhoneNumber", source="person.phoneNumber"),
            @Mapping(target="personAdress", source="person.adress")
    })
    PersonDTO personToPersonDTO(Person person);

}


