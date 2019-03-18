package training.endava.app.DTOMapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import training.endava.app.domain.Person;
import training.endava.app.domain.hibernateObjects.PersonInfo;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
    PersonDTO persontoPersonDTO(Person person);
    Person personDTOtoPerson(PersonDTO dto);
//    PersonInfoDTO personInfoToPersonInfoDTO(PersonInfo personInfo);
//    PersonInfo personInfoDTOToPersonInfo(PersonInfoDTO personInfo);
}
