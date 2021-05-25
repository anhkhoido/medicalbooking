package com.anhkhoido.pomelo.controller;

import com.anhkhoido.pomelo.dao.appointment.AppointmentRepository;
import com.anhkhoido.pomelo.dao.availability.AvailabilityRepository;
import com.anhkhoido.pomelo.model.Appointment;
import com.anhkhoido.pomelo.model.Availability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/medicalBooking/appointments")
public class AppointmentController extends AbstractController {

    private AppointmentRepository appointmentRepository;
    private AvailabilityRepository availabilityRepository;

    @Autowired
    public AppointmentController(AppointmentRepository appointmentRepository, AvailabilityRepository availabilityRepository) {
        this.appointmentRepository = appointmentRepository;
        this.availabilityRepository = availabilityRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Appointment appointment) {
        Availability availability = availabilityRepository.findAvailabilityByProviderAndStartDateTimeAndEndDateTime(
                appointment.getProvider(),
                appointment.getStartDateTime(),
                appointment.getEndDateTime()).get();
        if (availability != null) {
            appointmentRepository.save(appointment);
            availabilityRepository.delete(availability);
        }
    }

    @GetMapping(path = "/{id}")
    public Appointment findById(@PathVariable(value = "id") Integer id) {
        return appointmentRepository.findById(id).get();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable(value = "id") Integer id) {
        Appointment appointment = appointmentRepository.findById(id).get();
        Availability availability = Availability.builder()
                .provider(appointment.getProvider())
                .startDateTime(appointment.getStartDateTime())
                .endDateTime(appointment.getEndDateTime())
                .build();
        availabilityRepository.save(availability);
        appointmentRepository.deleteById(id);
    }

    @Override
    public Iterable<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public void deleteAll() {
        appointmentRepository.deleteAll();
    }
}
