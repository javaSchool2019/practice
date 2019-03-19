package training.endava.app.payload.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import training.endava.app.domain.entity.PersonDetails;
import training.endava.app.payload.PersonDetailsDTO;

@Mapper
public interface PersonDetailsMapper {
    PersonDetailsMapper INSTANCE = Mappers.getMapper(PersonDetailsMapper.class);
    @Mappings({
            @Mapping(target="description", source="entity.description"),
    })
    PersonDetailsDTO personDetailsTopersonDetailsDTO(PersonDetails entity);
}
