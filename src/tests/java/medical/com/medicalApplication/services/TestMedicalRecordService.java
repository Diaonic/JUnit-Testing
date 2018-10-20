package medical.com.medicalApplication.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import medical.com.medicalApplication.model.Allergy;
import medical.com.medicalApplication.model.MedicalRecord;
import medical.com.medicalApplication.model.Patient;

public class TestMedicalRecordService {

	private MedicalRecordService medicalRecordService;
	private List<Patient> expectedPatients;
	
	@Before
	public void before() {
		medicalRecordService = MedicalRecordService.getReference();
		expectedPatients = medicalRecordService.getAllPatients();
	}
	
	@Test
	public void testGetReference() {
		assertNotNull("Medical record service object is null", medicalRecordService);
	}
	
	@Test
	public void testAddPatients() {	
		boolean addPatientSuccess = medicalRecordService.addPatient("Barack Obama", "6631");
		//assert
		assertTrue("medicalRecordService failed to add patient: 6631", addPatientSuccess);
		assertNotNull("patient list is null", expectedPatients);
		assertTrue("unable to add patient, id already exists",addPatientSuccess);
		assertTrue("unable to locate specified patient id",
				expectedPatients.stream().anyMatch(patient->patient.getId().equals("6631")));
		assertTrue("unable to locate specified patient name",
				expectedPatients.stream().anyMatch(patient->patient.getName().equals("Barack Obama")));
	}
	
	@Test
	public void testGetAllPatients() {	
		boolean addBillSuccess = medicalRecordService.addPatient("Bill Clinton", "8797");
		//find bill
		assertTrue("medicalRecordService failed to add patient: 8797", addBillSuccess);
		assertNotNull("expectedDoctor List is null", expectedPatients);
		assertTrue("unable to locate Patient: Bill Clinton",
				expectedPatients.stream().anyMatch(patient->patient.getName().equals("Bill Clinton")));
		assertTrue("unable to locate Doctor Id: 1001",
				expectedPatients.stream().anyMatch(patient->patient.getId().equals("8797")));
	}
	
	@Test
	public void testGetMedicalRecord() {	
		//act
		MedicalRecord medicalRecord = medicalRecordService.getMedicalRecord("8797");
		Patient expectedPatient = medicalRecord.getPatient();
		//assert
		assertNotNull("medicalRecordService returned null object", medicalRecord);
		assertEquals("patient:8797 returned incorrect name", expectedPatient.getName(), "Bill Clinton");
		assertEquals("patient:Bill Clinton returned incorrect ID", expectedPatient.getId(), "8797");
	}
	
	@Test
	public void testGetPatient() {
		//act
		Patient actualPatient = medicalRecordService.getPatient("8797");
		//assert
		assertNotNull("actualPatient returned null object", actualPatient);
		assertEquals("patient:8797 returned incorrect name", actualPatient.getName(), "Bill Clinton");
		assertEquals("patient:Bill Clinton returned incorrect ID", actualPatient.getId(), "8797");
	}
	
	@Test
	public void testGetPatientsWithAllergies() {
		String patientId = "4419";
		Allergy peanutAllergy = new Allergy("Peanuts");

		medicalRecordService.addPatient("Peanut Man", patientId);	
		MedicalRecord medRecord = medicalRecordService.getMedicalRecord(patientId);
		medRecord.getHistory().addAllergy(peanutAllergy);
		
		List<Patient> patientList = medicalRecordService.getPatientsWithAllergies("Peanuts");
		assertNotNull("allergy object is null", peanutAllergy);
		assertNotNull("medrecord object is null", medRecord);
		assertNotNull("patientList object is null", medRecord);
		assertTrue("testGetAllergies returned null or 0", patientList.size() >= 1);
	}
	
	@After
	public void after() {
		medicalRecordService = null;
		expectedPatients = null;
	}
}
