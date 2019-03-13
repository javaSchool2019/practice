package training.endava.app.payload.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import training.endava.app.domain.Person;
import training.endava.app.payload.PersonDTO;


@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
    @Mappings({
            @Mapping(target="name", source="entity.name")
    })
    PersonDTO personToPersonDTO(Person entity);

}
