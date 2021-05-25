package com.anhkhoido.pomelo.controller;

import com.anhkhoido.pomelo.dao.availability.AvailabilityRepository;
import com.anhkhoido.pomelo.model.Availability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/medicalBooking/availabilities")
public class AvailabilityController extends AbstractController {

    private AvailabilityRepository availabilityRepository;

    @Autowired
    public AvailabilityController(AvailabilityRepository availabilityRepository) {
        this.availabilityRepository = availabilityRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Availability availability) {
        availabilityRepository.save(availability);
    }

    @Override
    public Iterable<Availability> findAll() {
        return availabilityRepository.findAll();
    }

    @Override
    public void deleteAll() {
        availabilityRepository.deleteAll();
    }
}
