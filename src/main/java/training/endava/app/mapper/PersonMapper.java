package training.endava.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import training.endava.app.domain.Person;
import training.endava.app.dto.PersonDTO;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE= Mappers.getMapper(PersonMapper.class);

    @Mappings({
            @Mapping(target="personId", source="person.id"),
            @Mapping(target="personName", source="person.name"),
            @Mapping(target="personEmail", source="person.email"),
            @Mapping(target="personPhone",  constant = "NULL"),
            @Mapping(target="personAddress", constant = "NULL")
    })
    PersonDTO personToPersonDTO (Person person);
}
