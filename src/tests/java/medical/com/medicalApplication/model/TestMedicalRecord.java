package medical.com.medicalApplication.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMedicalRecord {
	
	private MedicalRecord medRecord;
	private Patient patient;
	private PatientHistory history; 
	
	@Before
	public void before() {
		this.patient 	= new Patient("Jane", "1");
		this.medRecord 	= new MedicalRecord(patient);
		this.history 	= medRecord.getHistory();		
	}
	
	@Test
	public void testGetHistory() {
		//Assign known values
		Allergy allergy = new Allergy("Apples");
		history.addAllergy(allergy);	
		Medication med = new Medication("Cookies","9/25/2018","9/28/2018","100mg");
		history.addMedication(med);	
		Treatment treat = new Treatment("9/25/2018","cookie deprevation", "The patient suffers from a lack of good cookies");
		history.addTreatment(treat);

		//Get values
		List<Allergy> expectedAllergies = history.getAllergies();
		List<Medication> expectedMeds = history.getAllMedications();
		List<Treatment> expectedTreatment = history.getAllTreatments();

		//Test values
		assertTrue(expectedAllergies.contains(allergy));
		assertTrue(expectedMeds.contains(med));
		assertTrue(expectedTreatment.contains(treat));
	}
	
	@Test
	public void testGetPatient() {
		//instance of our patient
		Patient patient = medRecord.getPatient();

		//expected values
		String expectedName = "Jane";
		String expectedId = "1";
		
		//test expected against actual
		assertEquals(expectedName,patient.getName());
		assertEquals(expectedId,patient.getId());
	}
	
	@After
	public void after() {
		medRecord = null;
		patient = null;
		history = null;
	}
	

}
