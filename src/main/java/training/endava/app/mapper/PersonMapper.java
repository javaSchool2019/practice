package training.endava.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import training.endava.app.domain.Person;
import training.endava.app.payload.PersonDto;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

//    @Mappings({
//            @Mapping(source = "name", target = "personName"),
//            @Mapping(source = "age", target = "personAge"),
//    })
    PersonDto toDto(Person person);


//    @Mappings({
//            @Mapping(ignore = true, target = "id"),
//            @Mapping(source = "personName", target = "name"),
//            @Mapping(source = "personAge", target = "age")
//    })
    Person toPerson(PersonDto personDto);
}
