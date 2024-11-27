package pfa.ace_tp_revision.service.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pfa.ace_tp_revision.dao.entities.Phone;
import pfa.ace_tp_revision.service.dtos.PhoneDTO;

@Component
public class PhoneMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public PhoneDTO toDTO(Phone phone) {
        return modelMapper.map(phone, PhoneDTO.class);
    }

    public Phone toEntity(PhoneDTO phoneDTO) {
        return modelMapper.map(phoneDTO, Phone.class);
    }
}
