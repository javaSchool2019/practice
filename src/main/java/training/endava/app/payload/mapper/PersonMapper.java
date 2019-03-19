package training.endava.app.payload.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import training.endava.app.domain.entity.Person;
import training.endava.app.payload.PersonDTO;



@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
    @Mappings({
            @Mapping(target="name", source="entity.name"),
            @Mapping(target = "personDetails", source = "entity.personDetails"),
            @Mapping(target = "surName", source = "entity.surname"),
            @Mapping(target = "address", source = "entity.address"),
            @Mapping(target = "phoneNumbers", source = "entity.phoneNumbers")
    })
    PersonDTO personToPersonDTO(Person entity);

}
