package com.anhkhoido.pomelo.model;

import com.anhkhoido.pomelo.embeddedId.PersonCompositePrimaryKey;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PatientTest {

    @Test
    @DisplayName("Test should pass when the patient is not null.")
    public void testBuildPatient() {
        Patient patient = Patient.builder()
                .patientCompositeKey(getPatientCompositePrimaryKey())
                .clinic(getClinic())
                .build();
        Assertions.assertNotNull(patient.getClinic());
        Assertions.assertEquals("Sakura", patient.getPatientCompositeKey().getFirstName());
    }

    private PersonCompositePrimaryKey getPatientCompositePrimaryKey() {
        return PersonCompositePrimaryKey.builder()
                .firstName("Sakura")
                .lastName("Kokumai").build();
    }

    private Clinic getClinic() {
        return Clinic.builder().name("akdClinic").build();
    }

}
