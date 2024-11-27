package pfa.ace_tp_revision.service;

import org.springframework.stereotype.Service;
import pfa.ace_tp_revision.service.dtos.PhoneDTO;

import java.util.List;

@Service
public interface PhoneManager {
    PhoneDTO savePhone(PhoneDTO phoneDTO);
    PhoneDTO deletePhone(Long idPhone);
    List<PhoneDTO> getPhoneByModel(String model);
    List<PhoneDTO> getPhoneByModelAndPrice(String model, Float price);

}
