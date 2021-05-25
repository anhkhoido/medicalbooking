package com.anhkhoido.pomelo.controller;

import com.anhkhoido.pomelo.dao.patient.PatientRepository;
import com.anhkhoido.pomelo.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/medicalBooking/patients")
public class PatientController extends AbstractController {

    private PatientRepository patientRepository;

    @Autowired
    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Iterable<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public void deleteAll() {
        patientRepository.deleteAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Patient patient) {
        patientRepository.save(patient);
    }
}
