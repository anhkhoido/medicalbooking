package com.anhkhoido.pomelo.dao.patient;

import com.anhkhoido.pomelo.embeddedId.PersonCompositePrimaryKey;
import com.anhkhoido.pomelo.model.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientRepository extends CrudRepository<Patient, PersonCompositePrimaryKey> {
    List<Patient> findPatientByPatientCompositeKey_FirstName(String firstName);
    List<Patient> findPatientByPatientCompositeKey_LastName(String lastName);
}
