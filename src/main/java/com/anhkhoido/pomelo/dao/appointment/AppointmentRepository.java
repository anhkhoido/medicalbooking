package com.anhkhoido.pomelo.dao.appointment;

import com.anhkhoido.pomelo.model.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
}
