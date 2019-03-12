package training.endava.app.domain;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mappings(@Mapping(target = "personName", source = "entity.name"))
    PersonDTO personToPersonDTO(Person entity);

    @Mappings(@Mapping(target = "name", source = "dto.personName"))
    Person personDTOToPerson(PersonDTO dto);
}
