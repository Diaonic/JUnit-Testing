package medical.com.medicalApplication.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import medical.com.medicalApplication.model.Doctor;
import medical.com.medicalApplication.services.DoctorService;

public class TestDoctorService {
	private DoctorService doctorService;
	
	@Before
	public void before() {
		doctorService = DoctorService.getReference();
	}
	
	@Test
	public void testGetReference() {
		assertNotNull(DoctorService.getReference());
	}
	

	@Test
	public void testGetAllDoctors() {
		//arrange
		doctorService.addDoctor("Dr. Seuss", "1001");
		doctorService.addDoctor("Dr. Watson", "1002");

		//act
		List<Doctor> expectedDoctors = doctorService.getAllDoctors();
	
		//find dr. seuss
		assertNotNull("expectedDoctor List is null", expectedDoctors);
		assertTrue("unable to locate Doctor: Dr. Seuss",
				expectedDoctors.stream().anyMatch(doctor->doctor.getName().equals("Dr. Seuss")));
		assertTrue("unable to locate Doctor Id: 1001",
				expectedDoctors.stream().anyMatch(doctor->doctor.getId().equals("1001")));
		//find dr.watson
		assertTrue("unable to locate Doctor: Dr. Watson",
				expectedDoctors.stream().anyMatch(doctor->doctor.getName().equals("Dr. Watson")));
		assertTrue("unable to locate Doctor Id: 1002",
				expectedDoctors.stream().anyMatch(allergy->allergy.getId().equals("1002")));
	}
	
	@Test
	public void testAddDoctor() {
		//arrange
		String doctorId = "567";
		String doctorName = "Alan Kono";
		
		//act
		boolean addDoctorSuccess = doctorService.addDoctor(doctorName, doctorId);	
		List<Doctor> doctorList = doctorService.getAllDoctors();
		
		//assert
		assertNotNull("doctor List is null", doctorList);
		assertTrue("unable to add doctor, id already exists",addDoctorSuccess);
		assertTrue("unable to locate specified doctor id",
				doctorList.stream().anyMatch(doctor->doctor.getId().equals("567")));
		assertTrue("unable to locate specified doctor name",
				doctorList.stream().anyMatch(doctor->doctor.getName().equals("Alan Kono")));
	};
	
}
