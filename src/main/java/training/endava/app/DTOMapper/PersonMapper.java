package training.endava.app.DTOMapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import training.endava.app.domain.Person;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
    PersonDTO persontoPersonDTO(Person person);
    Person personDTOtoPerson(PersonDTO dto);
}
