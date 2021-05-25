package com.anhkhoido.pomelo.dao.appointment;

import com.anhkhoido.pomelo.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentRepository {

    private AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public <S extends Appointment> Iterable<S> saveAll(Iterable<S> iterable) {
        return appointmentRepository.saveAll(iterable);
    }

    @Override
    public Optional<Appointment> findById(Integer id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return appointmentRepository.existsById(id);
    }

    @Override
    public Iterable<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Iterable<Appointment> findAllById(Iterable<Integer> iterable) {
        return appointmentRepository.findAllById(iterable);
    }

    @Override
    public long count() {
        return appointmentRepository.count();
    }

    @Override
    public void deleteById(Integer id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public void delete(Appointment appointment) {
        appointmentRepository.delete(appointment);
    }

    @Override
    public void deleteAll(Iterable<? extends Appointment> iterable) {
        appointmentRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        appointmentRepository.deleteAll();
    }
}
