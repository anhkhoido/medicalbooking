package com.anhkhoido.pomelo.service;

import com.anhkhoido.pomelo.dao.clinic.ClinicServiceImpl;
import com.anhkhoido.pomelo.dao.provider.ProviderServiceImpl;
import com.anhkhoido.pomelo.embeddedId.PersonCompositePrimaryKey;
import com.anhkhoido.pomelo.model.Clinic;
import com.anhkhoido.pomelo.model.Provider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class ProviderServiceImplTest {

    @Autowired
    private ProviderServiceImpl providerService;

    @Autowired
    private ClinicServiceImpl clinicService;

    private final String MY_CLINIC = "akdClinic";

    @BeforeEach
    public void createClinic() {
        clinicService.save(getClinic(MY_CLINIC));
    }

    @Test
    @DisplayName("Test should pass if I can add a provider")
    public void testAdditionOfProvider() {
        Provider provider = Provider.builder()
                .providerCompositePrimaryKey(getCompositeKey("Dan", "Wesson"))
                .clinic(getClinic(MY_CLINIC))
                .build();
        providerService.save(provider);
        Assertions.assertFalse(providerService.count() == 0);
    }

    private Clinic getClinic(String name) {
        return Clinic.builder().name(name).build();
    }

    private PersonCompositePrimaryKey getCompositeKey(String firstName, String lastName) {
        return PersonCompositePrimaryKey.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();
    }

}
