package training.endava.app.domain;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "Person")
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mappings({
            @Mapping(target = "firstName", source = "entity.firstName"),
            @Mapping(target = "lastName", source = "entity.lastName"),
            @Mapping(target = "address", source = "entity.address"),
            @Mapping(target = "phoneNumbers", source = "entity.phoneNumbers")
    })
    PersonDTO personToPersonDTO(Person entity);

    @Mappings({
            @Mapping(target = "firstName", source = "dto.firstName"),
            @Mapping(target = "lastName", source = "dto.lastName"),
            @Mapping(target = "address", source = "dto.address"),
            @Mapping(target = "phoneNumbers", source = "dto.phoneNumbers")
    })
    Person personDTOToPerson(PersonDTO dto);
}
