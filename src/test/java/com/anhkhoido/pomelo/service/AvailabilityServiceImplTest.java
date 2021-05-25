package com.anhkhoido.pomelo.service;

import com.anhkhoido.pomelo.dao.availability.AvailabilityServiceImpl;
import com.anhkhoido.pomelo.dao.clinic.ClinicServiceImpl;
import com.anhkhoido.pomelo.dao.provider.ProviderServiceImpl;
import com.anhkhoido.pomelo.embeddedId.PersonCompositePrimaryKey;
import com.anhkhoido.pomelo.model.Availability;
import com.anhkhoido.pomelo.model.Clinic;
import com.anhkhoido.pomelo.model.Provider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@SpringBootTest
@Transactional
public class AvailabilityServiceImplTest {

    @Autowired
    private AvailabilityServiceImpl availabilityService;

    @Autowired
    private ProviderServiceImpl providerService;

    @Autowired
    private ClinicServiceImpl clinicService;

    private final String MY_CLINIC = "akdClinic";

    @BeforeEach
    public void createProviderAndClinic() {
        clinicService.save(getClinic(MY_CLINIC));
        providerService.save(getProvider());
    }

    @Test
    @DisplayName("Test should pass when starting and closing hours are timeslots of 15 minutes.")
    public void testStartDateOnlyAcceptsHoursThatAreTimeslotsOfFifteenMinutes() {
        Timestamp startDate = Timestamp.valueOf("2021-02-04 04:02:00");
        Timestamp endDate = Timestamp.valueOf("2021-02-04 04:05:00");
        Availability availability = Availability.builder()
                .startDateTime(startDate)
                .endDateTime(endDate)
                .provider(getProvider())
                .build();
        availabilityService.save(availability);
        Assertions.assertTrue(availabilityService.count() == 0);
    }

    private Clinic getClinic(String name) {
        return Clinic.builder().name(name).build();
    }

    private Provider getProvider() {
        return Provider.builder().providerCompositePrimaryKey(getProviderPrimaryKey("Najwa", "Nimri")).clinic(getClinic(MY_CLINIC)).build();
    }

    private PersonCompositePrimaryKey getProviderPrimaryKey(String firstName, String lastName) {
        return PersonCompositePrimaryKey.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();
    }

}
