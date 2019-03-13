package training.endava.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import training.endava.app.domain.Person;
import training.endava.app.filter.PersonDTO;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mappings({
            @Mapping(target="personID", source="person.id"),
            @Mapping(target="personName", source="person.name"),
            @Mapping(target="personAddress", source="person.address")
    })

    PersonDTO personToPersonDTO(Person person);

}