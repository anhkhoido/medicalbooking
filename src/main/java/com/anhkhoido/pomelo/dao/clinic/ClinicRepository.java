package com.anhkhoido.pomelo.dao.clinic;

import com.anhkhoido.pomelo.model.Clinic;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClinicRepository extends CrudRepository<Clinic, String> {
    Optional<Clinic> findClinicByName(String name);
    void deleteClinicByName(String name);
}
