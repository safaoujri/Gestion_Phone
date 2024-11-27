package pfa.ace_tp_revision.service;

import org.springframework.stereotype.Service;
import pfa.ace_tp_revision.dao.entities.Phone;
import pfa.ace_tp_revision.dao.repositories.PhoneRepository;
import pfa.ace_tp_revision.service.dtos.PhoneDTO;
import pfa.ace_tp_revision.service.mappers.PhoneMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneManagerAction implements PhoneManager{
    private final PhoneRepository phoneRepository;
    private final PhoneMapper phoneMapper;

    public PhoneManagerAction(PhoneRepository phoneRepository, PhoneMapper phoneMapper) {
        this.phoneRepository = phoneRepository;
        this.phoneMapper = phoneMapper;
    }

//    public PhoneDTO savePhone(PhoneDTO phoneDTO) {
//        if (phoneRepository.existsByIMEI(phoneDTO.getIMEI())) {
//            throw new RuntimeException("Phone with IMEI already exists!");
//        }
//        Phone phone = phoneMapper.toEntity(phoneDTO);
//        return phoneMapper.toDTO(phoneRepository.save(phone));
//    }
public PhoneDTO savePhone(PhoneDTO phoneDTO) {
    if (phoneDTO == null) {
        throw new RuntimeException("phoneDTO is null");
    }

    if (phoneRepository.existsByIMEI(phoneDTO.getIMEI())) {
        throw new RuntimeException("Phone with IMEI already exists!");
    }

    Phone phone = phoneMapper.toEntity(phoneDTO);
    phone = phoneRepository.save(phone);

    return phoneMapper.toDTO(phone);
}



    public PhoneDTO deletePhone(Long idPhone) {
        Phone phone = phoneRepository.findById(idPhone)
                .orElseThrow(() -> new RuntimeException("Phone not found"));
        phoneRepository.delete(phone);
        return phoneMapper.toDTO(phone);
    }


    public List<PhoneDTO> getPhoneByModel(String model) {
        return phoneRepository.findByModel(model)
                .stream()
                .map(phoneMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<PhoneDTO> getPhoneByModelAndPrice(String model, Float price) {
        return phoneRepository.findByModelAndPrice(model, price)
                .stream()
                .map(phoneMapper::toDTO)
                .collect(Collectors.toList());
    }
}
