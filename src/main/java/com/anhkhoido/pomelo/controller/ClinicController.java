package com.anhkhoido.pomelo.controller;

import com.anhkhoido.pomelo.dao.clinic.ClinicRepository;
import com.anhkhoido.pomelo.model.Clinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/medicalBooking/clinics")
public class ClinicController extends AbstractController {

    private ClinicRepository clinicRepository;

    @Autowired
    public ClinicController(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Clinic clinic) {
        if (clinicRepository.count() <= 1) {
            clinicRepository.save(clinic);
        }
    }

    @GetMapping(path = "/{id}")
    public Clinic findById(@PathVariable(value = "id") String id) {
        return clinicRepository.findById(id).get();
    }

    @Override
    public Iterable<Clinic> findAll() {
        return clinicRepository.findAll();
    }

    @Override
    public void deleteAll() {
        clinicRepository.deleteAll();
    }
}
