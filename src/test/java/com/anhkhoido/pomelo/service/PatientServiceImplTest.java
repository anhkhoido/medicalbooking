package com.anhkhoido.pomelo.service;

import com.anhkhoido.pomelo.dao.clinic.ClinicServiceImpl;
import com.anhkhoido.pomelo.dao.patient.PatientServiceImpl;
import com.anhkhoido.pomelo.embeddedId.PersonCompositePrimaryKey;
import com.anhkhoido.pomelo.model.Clinic;
import com.anhkhoido.pomelo.model.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@SpringBootTest
@Transactional
public class PatientServiceImplTest {

    @Autowired
    private PatientServiceImpl patientService;

    @Autowired
    private ClinicServiceImpl clinicService;

    private final String MY_CLINIC = "akdClinic";

    @BeforeEach
    public void createClinic() {
        clinicService.save(getClinic(MY_CLINIC));
    }

    @Test
    @DisplayName("Test should pass if one deletion works.")
    public void testDeletionOfPatients() {
        Patient patient001 = Patient.builder()
                .patientCompositeKey(getPatientCompositePrimaryKey("Kate", "Winslet"))
                .clinic(getClinic(MY_CLINIC))
                .build();

        Patient patient002 = Patient.builder()
                .patientCompositeKey(getPatientCompositePrimaryKey("Marie", "Curie"))
                .clinic(getClinic(MY_CLINIC))
                .build();

        patientService.saveAll(Arrays.asList(patient001, patient002));
        Assertions.assertTrue(patientService.count() == 2);
        patientService.delete(patient001);
        Assertions.assertTrue(patientService.count() == 1);
    }

    @Test
    @DisplayName("Test should pass if constraint of primary key blocks duplicates")
    public void testCompositePrimaryKeys() {
        Patient patient001 = Patient.builder()
                .patientCompositeKey(getPatientCompositePrimaryKey("Kate", "Winslet"))
                .clinic(getClinic(MY_CLINIC))
                .build();

        Patient patientForRejection = Patient.builder()
                .patientCompositeKey(getPatientCompositePrimaryKey("Kate", "Winslet"))
                .clinic(getClinic(MY_CLINIC))
                .build();
        patientService.saveAll(Arrays.asList(patient001, patientForRejection));
        Assertions.assertTrue(patientService.count() == 1);
    }

    @Test
    @DisplayName("Test should pass if deletion of all patients works")
    public void testDeleteAll() {
        Patient patient001 = Patient.builder()
                .patientCompositeKey(getPatientCompositePrimaryKey("Kate", "Winslet"))
                .clinic(getClinic(MY_CLINIC))
                .build();

        Patient patient002 = Patient.builder()
                .patientCompositeKey(getPatientCompositePrimaryKey("Marie", "Curie"))
                .clinic(getClinic(MY_CLINIC))
                .build();

        Patient patient003 = Patient.builder()
                .patientCompositeKey(getPatientCompositePrimaryKey("Julie", "Estelle"))
                .clinic(getClinic(MY_CLINIC))
                .build();
        patientService.saveAll(Arrays.asList(patient001, patient002, patient003));
        Assertions.assertTrue(patientService.count() == 3);
        patientService.deleteAll();
        Assertions.assertTrue(patientService.count() == 0);
    }

    private PersonCompositePrimaryKey getPatientCompositePrimaryKey(String firstName, String lastName) {
        return PersonCompositePrimaryKey.builder()
                .firstName(firstName)
                .lastName(lastName).build();
    }

    private Clinic getClinic(String name) {
        return Clinic.builder().name(name).build();
    }

}
