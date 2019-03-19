package training.endava.app.payload.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import training.endava.app.domain.entity.PhoneNumber;
import training.endava.app.payload.PhoneNumberDTO;

@Mapper
public interface PhoneNumberMapper {
    PhoneNumberMapper INSTANCE = Mappers.getMapper(PhoneNumberMapper.class);
    @Mappings({
            @Mapping(target="number", source="entity.number"),
    })
    PhoneNumberDTO phoneNumberToPhoneNumberDTO(PhoneNumber entity);
}
