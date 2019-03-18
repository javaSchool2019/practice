package training.endava.app.domain;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "Person")
public interface PersonMapper {

//    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
//
//    @Mappings({
//            @Mapping(target = "firstName", source = "entity.firstName"),
//            @Mapping(target = "lastName", source = "entity.lastName")
//    })
//    PersonDTO personToPersonDTO(Person entity);
//
//    @Mappings({
//            @Mapping(target = "firstName", source = "dto.firstName"),
//            @Mapping(target = "lastName", source = "dto.lastName")
//    })
//    Person personDTOToPerson(PersonDTO dto);
}
