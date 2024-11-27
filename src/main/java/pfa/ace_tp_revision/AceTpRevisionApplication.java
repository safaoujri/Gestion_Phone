package pfa.ace_tp_revision;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pfa.ace_tp_revision.dao.entities.Phone;
import pfa.ace_tp_revision.dao.repositories.PhoneRepository;

@SpringBootApplication
public class AceTpRevisionApplication {

    public static void main(String[] args) {
        SpringApplication.run(AceTpRevisionApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(PhoneRepository phoneRepository) {
        return args -> {
            phoneRepository.save(new Phone(null, "iPhone", "Black", "123456789", 999.99f));
            phoneRepository.save(new Phone(null, "Samsung", "Blue", "987654321", 799.99f));
            phoneRepository.save(new Phone(null, "Nokia", "Gray", "112233445", 199.99f));
            phoneRepository.save(new Phone(null, "Pixel", "White", "998877665", 899.99f));
        };
    }

}
