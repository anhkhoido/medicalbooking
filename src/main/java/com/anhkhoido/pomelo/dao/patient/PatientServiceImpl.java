package com.anhkhoido.pomelo.dao.patient;

import com.anhkhoido.pomelo.embeddedId.PersonCompositePrimaryKey;
import com.anhkhoido.pomelo.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientRepository {

    private PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public <S extends Patient> Iterable<S> saveAll(Iterable<S> iterable) {
        return patientRepository.saveAll(iterable);
    }

    @Override
    public Optional<Patient> findById(PersonCompositePrimaryKey personCompositePrimaryKey) {
        return patientRepository.findById(personCompositePrimaryKey);
    }

    @Override
    public boolean existsById(PersonCompositePrimaryKey personCompositePrimaryKey) {
        return patientRepository.existsById(personCompositePrimaryKey);
    }

    @Override
    public Iterable<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Iterable<Patient> findAllById(Iterable<PersonCompositePrimaryKey> iterable) {
        return patientRepository.findAllById(iterable);
    }

    @Override
    public long count() {
        return patientRepository.count();
    }

    @Override
    public void deleteById(PersonCompositePrimaryKey personCompositePrimaryKey) {
        patientRepository.deleteById(personCompositePrimaryKey);
    }

    @Override
    public void delete(Patient patient) {
        patientRepository.delete(patient);
    }

    @Override
    public void deleteAll(Iterable<? extends Patient> iterable) {
        patientRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        patientRepository.deleteAll();
    }

    @Override
    public List<Patient> findPatientByPatientCompositeKey_FirstName(@Param("firstName") String firstName) {
        return patientRepository.findPatientByPatientCompositeKey_FirstName(firstName);
    }

    @Override
    public List<Patient> findPatientByPatientCompositeKey_LastName(@Param("lastName") String lastName) {
        return patientRepository.findPatientByPatientCompositeKey_LastName(lastName);
    }
}
