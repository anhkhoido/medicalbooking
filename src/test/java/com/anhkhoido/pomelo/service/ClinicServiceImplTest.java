package com.anhkhoido.pomelo.service;

import com.anhkhoido.pomelo.dao.clinic.ClinicServiceImpl;
import com.anhkhoido.pomelo.model.Clinic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class ClinicServiceImplTest {

    @Autowired
    private ClinicServiceImpl service;

    @Test
    public void testCreationOfClinic() {
        service.save(getClinic());
        long numberOfClinics = service.count();
        Assertions.assertEquals(1, numberOfClinics);
    }

    private Clinic getClinic() {
        return Clinic.builder().name("akdClinic").build();
    }

}
