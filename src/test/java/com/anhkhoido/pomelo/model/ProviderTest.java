package com.anhkhoido.pomelo.model;

import com.anhkhoido.pomelo.embeddedId.PersonCompositePrimaryKey;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProviderTest {

    @Test
    @DisplayName("Test should pass when the provider is built.")
    public void testBuildProvider() {
        Provider provider = Provider.builder()
                .providerCompositePrimaryKey(getPatientCompositePrimaryKey())
                .clinic(getClinic())
                .build();
        Assertions.assertEquals("Ninh", provider.getProviderCompositePrimaryKey().getLastName());
        Assertions.assertEquals("akdClinic", provider.getClinic().getName());
    }

    private PersonCompositePrimaryKey getPatientCompositePrimaryKey() {
        return PersonCompositePrimaryKey.builder()
                .firstName("Duong Lan Ngoc")
                .lastName("Ninh")
                .build();
    }

    private Clinic getClinic() {
        return Clinic.builder().name("akdClinic").build();
    }
}
