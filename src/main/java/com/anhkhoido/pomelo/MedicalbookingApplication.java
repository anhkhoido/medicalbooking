package com.anhkhoido.pomelo;

import com.anhkhoido.pomelo.dao.appointment.AppointmentServiceImpl;
import com.anhkhoido.pomelo.dao.availability.AvailabilityServiceImpl;
import com.anhkhoido.pomelo.dao.clinic.ClinicServiceImpl;
import com.anhkhoido.pomelo.dao.patient.PatientServiceImpl;
import com.anhkhoido.pomelo.dao.provider.ProviderServiceImpl;
import com.anhkhoido.pomelo.embeddedId.PersonCompositePrimaryKey;
import com.anhkhoido.pomelo.model.Availability;
import com.anhkhoido.pomelo.model.Clinic;
import com.anhkhoido.pomelo.model.Patient;
import com.anhkhoido.pomelo.model.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;

@SpringBootApplication
public class MedicalbookingApplication implements CommandLineRunner {

	@Autowired
	private ClinicServiceImpl clinicServiceImpl;

	@Autowired
	private PatientServiceImpl patientServiceImpl;

	@Autowired
	private ProviderServiceImpl providerServiceImpl;

	@Autowired
	private AvailabilityServiceImpl availabilityServiceImpl;

	@Autowired
	private AppointmentServiceImpl appointmentServiceImpl;


	public static void main(String[] args) {
		SpringApplication.run(MedicalbookingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createClinic();
		createProviders();
		createPatients();
		createAvailabilities();
	}

	private void createClinic() {
		Clinic clinic = Clinic.builder().name("akdClinic").build();
		clinicServiceImpl.save(clinic);
	}

	private void  createPatients() {
		Clinic clinic = Clinic.builder().name("akdClinic").build();
		PersonCompositePrimaryKey patientKey001 = PersonCompositePrimaryKey.builder()
				.firstName("Christine")
				.lastName("Landry")
				.build();

		PersonCompositePrimaryKey patientKey002 = PersonCompositePrimaryKey.builder()
				.firstName("Christina")
				.lastName("Bui")
				.build();

		Patient patient001 = Patient.builder()
				.clinic(clinic)
				.patientCompositeKey(patientKey001)
				.build();

		Patient patient002 = Patient.builder()
				.patientCompositeKey(patientKey002)
				.clinic(clinic)
				.build();

		patientServiceImpl.save(patient001);
		patientServiceImpl.save(patient002);
	}

	private void createProviders() {
		Clinic clinic = Clinic.builder().name("akdClinic").build();
		PersonCompositePrimaryKey providerKey001 = PersonCompositePrimaryKey.builder()
				.firstName("My-Chi")
				.lastName("Phuong")
				.build();
		PersonCompositePrimaryKey providerKey002 = PersonCompositePrimaryKey.builder()
				.firstName("Thuy-Chi")
				.lastName("Le")
				.build();
		Provider provider001 = Provider.builder()
				.providerCompositePrimaryKey(providerKey001)
				.clinic(clinic)
				.build();
		Provider provider002 = Provider.builder()
				.providerCompositePrimaryKey(providerKey002)
				.clinic(clinic)
				.build();
		providerServiceImpl.save(provider001);
		providerServiceImpl.save(provider002);
	}

	public void createAvailabilities() {
		Clinic clinic = Clinic.builder().name("akdClinic").build();
		PersonCompositePrimaryKey providerKey001 = PersonCompositePrimaryKey.builder()
				.firstName("My-Chi")
				.lastName("Phuong")
				.build();
		Provider provider001 = Provider.builder()
				.providerCompositePrimaryKey(providerKey001)
				.clinic(clinic)
				.build();

		Availability availability001 = Availability.builder()
				.provider(provider001)
				.startDateTime(Timestamp.valueOf("2021-01-01 08:45:00"))
				.endDateTime(Timestamp.valueOf("2021-01-01 09:00:00"))
				.build();
		Availability availability002 = Availability.builder()
				.provider(provider001)
				.startDateTime(Timestamp.valueOf("2021-01-01 09:00:00"))
				.endDateTime(Timestamp.valueOf("2021-01-01 09:15:00"))
				.build();
		availabilityServiceImpl.save(availability001);
		availabilityServiceImpl.save(availability002);
	}

}
