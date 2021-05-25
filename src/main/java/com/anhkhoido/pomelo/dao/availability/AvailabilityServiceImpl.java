package com.anhkhoido.pomelo.dao.availability;

import com.anhkhoido.pomelo.model.Availability;
import com.anhkhoido.pomelo.model.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Optional;

@Service
public class AvailabilityServiceImpl implements AvailabilityRepository {

    private AvailabilityRepository availableRepository;

    @Autowired
    public AvailabilityServiceImpl(AvailabilityRepository availabilityRepository) {
        this.availableRepository = availabilityRepository;
    }

    @Override
    public Availability save(Availability availability) {
        boolean verifyMinutesInStartingHour = isMinutePartOfFifteenMinutesTimeslot(availability.getStartDateTime());
        boolean verifyMinutesInEndingHour = isMinutePartOfFifteenMinutesTimeslot(availability.getEndDateTime());
        if (verifyMinutesInStartingHour && verifyMinutesInEndingHour) {
            return availableRepository.save(availability);
        } else {
            return null;
        }
    }

    @Override
    public <S extends Availability> Iterable<S> saveAll(Iterable<S> iterable) {
        return availableRepository.saveAll(iterable);
    }

    @Override
    public Optional<Availability> findById(Integer id) {
        return availableRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return availableRepository.existsById(id);
    }

    @Override
    public Iterable<Availability> findAll() {
        return availableRepository.findAll();
    }

    @Override
    public Iterable<Availability> findAllById(Iterable<Integer> iterable) {
        return availableRepository.findAllById(iterable);
    }

    @Override
    public long count() {
        return availableRepository.count();
    }

    @Override
    public void deleteById(Integer id) {
        availableRepository.deleteById(id);
    }

    @Override
    public void delete(Availability availability) {
        availableRepository.delete(availability);
    }

    @Override
    public void deleteAll(Iterable<? extends Availability> iterable) {
        availableRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        availableRepository.deleteAll();
    }

    @Override
    public Optional<Availability> findAvailabilityByProviderAndStartDateTimeAndEndDateTime(Provider provider, Timestamp startTime, Timestamp endTime) {
        return availableRepository.findAvailabilityByProviderAndStartDateTimeAndEndDateTime(provider, startTime, endTime);
    }

    private boolean isMinutePartOfFifteenMinutesTimeslot(Timestamp timestamp) {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(timestamp);
        int minute = calendar.get(Calendar.MINUTE);
        return minute == 0 || minute % 15 == 0;
    }

}
