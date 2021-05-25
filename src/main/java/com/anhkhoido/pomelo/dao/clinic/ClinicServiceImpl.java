package com.anhkhoido.pomelo.dao.clinic;

import com.anhkhoido.pomelo.model.Clinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClinicServiceImpl implements ClinicRepository {

    private ClinicRepository clinicRepository;

    @Autowired
    public ClinicServiceImpl(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    @Override
    public Clinic save(Clinic clinic) {
        return clinicRepository.save(clinic);
    }

    @Override
    public <S extends Clinic> Iterable<S> saveAll(Iterable<S> iterable) {
        return clinicRepository.saveAll(iterable);
    }

    @Override
    public Optional<Clinic> findById(String id) {
        return clinicRepository.findClinicByName(id);
    }

    @Override
    public boolean existsById(String s) {
        return clinicRepository.findClinicByName(s) != null;
    }

    @Override
    public Iterable<Clinic> findAll() {
        return clinicRepository.findAll();
    }

    @Override
    public Iterable<Clinic> findAllById(Iterable<String> iterable) {
        return clinicRepository.findAllById(iterable);
    }

    @Override
    public long count() {
        return clinicRepository.count();
    }

    @Override
    public void deleteById(String id) {
        clinicRepository.deleteClinicByName(id);
    }

    @Override
    public void delete(Clinic clinic) {
        clinicRepository.delete(clinic);
    }

    @Override
    public void deleteAll(Iterable<? extends Clinic> iterable) {
        clinicRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        clinicRepository.deleteAll();
    }

    @Override
    public Optional<Clinic> findClinicByName(String name) {
        return clinicRepository.findClinicByName(name);
    }

    @Override
    public void deleteClinicByName(String name) {
        clinicRepository.deleteClinicByName(name);
    }
}
