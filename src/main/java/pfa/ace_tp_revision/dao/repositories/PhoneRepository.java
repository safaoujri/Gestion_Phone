package pfa.ace_tp_revision.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pfa.ace_tp_revision.dao.entities.Phone;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
    List<Phone> findByModel(String model);
    List<Phone> findByModelAndPrice(String model, Float price);
    boolean existsByIMEI(String IMEI);
}
