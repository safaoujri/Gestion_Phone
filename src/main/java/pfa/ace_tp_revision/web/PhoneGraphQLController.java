package pfa.ace_tp_revision.web;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import pfa.ace_tp_revision.service.PhoneManager;
import pfa.ace_tp_revision.service.dtos.PhoneDTO;

import java.util.List;

@Controller
public class PhoneGraphQLController {
    private final PhoneManager phoneManager;

    public PhoneGraphQLController(PhoneManager phoneManager) {
        this.phoneManager = phoneManager;
    }

    @QueryMapping
    public List<PhoneDTO> getPhoneByModel(@Argument String model) {
        return phoneManager.getPhoneByModel(model);
    }

    @QueryMapping
    public List<PhoneDTO> getPhoneByModelAndPrice(@Argument String model, @Argument Float price) {
        return phoneManager.getPhoneByModelAndPrice(model, price);
    }

//    @MutationMapping
//    public PhoneDTO savePhone(@Argument PhoneDTO phoneDTO) {
//        PhoneDTO phoneDTO1 = phoneManager.savePhone(phoneDTO);
//        return phoneManager.savePhone(phoneDTO);
//    }
@MutationMapping
public PhoneDTO savePhone(@Argument PhoneInput phoneInput) {
    if (phoneInput == null) {
        throw new RuntimeException("phoneInput is null");
    }

    // Mapper PhoneInput vers PhoneDTO
    PhoneDTO phoneDTO = new PhoneDTO(phoneInput.getModel(), phoneInput.getColor(), phoneInput.getIMEI(), phoneInput.getPrice());

    return phoneManager.savePhone(phoneDTO);
}


    @MutationMapping
    public PhoneDTO deletePhone(@Argument Long id) {
        return phoneManager.deletePhone(id);
    }
}
