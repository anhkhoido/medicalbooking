package com.anhkhoido.pomelo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClinicTest {

    private final String CLINIC_NAME = "myClinic";

    @Test
    @DisplayName("Test should pass when the clinic has a name.")
    public void testBuildOfClinic() {
        Clinic clinic = Clinic.builder().name(CLINIC_NAME).build();
        Assertions.assertNotNull(clinic);
        Assertions.assertEquals(CLINIC_NAME, clinic.getName());
    }
}
