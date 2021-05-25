package com.anhkhoido.pomelo.dao.availability;

import com.anhkhoido.pomelo.model.Availability;
import com.anhkhoido.pomelo.model.Provider;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.Optional;

public interface AvailabilityRepository extends CrudRepository<Availability, Integer> {
    Optional<Availability> findAvailabilityByProviderAndStartDateTimeAndEndDateTime(Provider provider, Timestamp startTime, Timestamp endTime);
}
