package medical.com.medicalApplication.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPatientHistory {

	private PatientHistory patientHistory;
	
	@Before
	public void before() {
		patientHistory = new PatientHistory();
	}
	
	@Test
	public void testAddAllergy() {
		Allergy allergy = new Allergy("Nuts");
		patientHistory.addAllergy(allergy);
		List<Allergy> expectedAllergies = patientHistory.getAllergies();
		assertTrue(expectedAllergies.contains(allergy));
	}
	
	@Test
	public void testAddMedication() {
		Medication medication = new Medication("Soup","9/25/2018","9/28/2018","1 Cup");
		patientHistory.addMedication(medication);
		List<Medication> expectedMedication = patientHistory.getAllMedications();
		assertTrue(expectedMedication.contains(medication));
	}
	
	@Test
	public void testAddTreatment() {
		Treatment treatment = new Treatment("9/25/2018","dizziness", "The patient suffers from dizziness");
		patientHistory.addTreatment(treatment);
		List<Treatment> expectedTreatment = patientHistory.getAllTreatments();
		assertTrue(expectedTreatment.contains(treatment));
	}
	
	@Test
	public void testGetAllergies() {
		//arrange
		patientHistory.addAllergy(new Allergy("Peanuts"));
		patientHistory.addAllergy(new Allergy("Apples"));
		
		//act
		List<Allergy> expectedAllergies = patientHistory.getAllergies();
		
		//assert
		assertEquals("testGetAllergies returned unexpected count", 2, expectedAllergies.size());
		assertTrue("unable to locate allergy Peanuts",
				expectedAllergies.stream().anyMatch(allergy->allergy.getName().equals("Peanuts")));
		assertTrue("unable to locate allergy Apples",
				expectedAllergies.stream().anyMatch(allergy->allergy.getName().equals("Apples")));
	}
	
	@Test
	public void testGetAllMedications() {
		//arrange
		patientHistory.addMedication(new Medication("Soup","9/25/2018","9/28/2018","1 Cup"));
		patientHistory.addMedication(new Medication("Tylenol","9/26/2018","9/29/2018","100 mg"));

		//act
		List<Medication> expectedMedications = patientHistory.getAllMedications();
		
		//assert
		assertEquals("testGetAllMedications returned unexpected count", 2, expectedMedications.size());
	
		assertTrue("unable to locate medication Soup",
				expectedMedications.stream().anyMatch(medication->medication.getName().equals("Soup")));
		assertTrue("unable to locate medication Start Date",
				expectedMedications.stream().anyMatch(medication->medication.getStartDate().equals("9/25/2018")));
		assertTrue("unable to locate medication End Date",
				expectedMedications.stream().anyMatch(medication->medication.getEndDate().equals("9/28/2018")));
		assertTrue("unable to locate medication doseage",
				expectedMedications.stream().anyMatch(medication->medication.getDose().equals("1 Cup")));
		
		assertTrue("unable to locate medication Tylenol",
				expectedMedications.stream().anyMatch(medication->medication.getName().equals("Tylenol")));
		assertTrue("unable to locate medication Start Date",
				expectedMedications.stream().anyMatch(medication->medication.getStartDate().equals("9/26/2018")));
		assertTrue("unable to locate medication End Date",
				expectedMedications.stream().anyMatch(medication->medication.getEndDate().equals("9/29/2018")));
		assertTrue("unable to locate medication Doseage",
				expectedMedications.stream().anyMatch(medication->medication.getDose().equals("100 mg")));
	}
	
	@Test
	public void testGetAllTreatments() {
		//arrange
		patientHistory.addTreatment(new Treatment("9/25/2018","headache", "The patient suffers from a headache"));
		patientHistory.addTreatment(new Treatment("9/26/2018","shoulder pain", "The patient suffers from a shoulder pain"));

		//act
		List<Treatment> expectedTreatments = patientHistory.getAllTreatments();
		
		//assert
		assertEquals("testGetAllTreatments returned unexpected count", 2, expectedTreatments.size());

		assertTrue("unable to locate treatment diagnose headache",
				expectedTreatments.stream().anyMatch(treatment->treatment.getDiagnose().equals("headache")));
		assertTrue("unable to locate treatment description",
				expectedTreatments.stream().anyMatch(treatment->treatment.getDescription().equals("The patient suffers from a headache")));
		assertTrue("unable to locate treatment date",
				expectedTreatments.stream().anyMatch(treatment->treatment.getTreatmentDate().equals("9/25/2018")));
		
		assertTrue("unable to locate treatment diagnose shoulder pain",
				expectedTreatments.stream().anyMatch(treatment->treatment.getDiagnose().equals("shoulder pain")));
		assertTrue("unable to locate treatment description",
				expectedTreatments.stream().anyMatch(treatment->treatment.getDescription().equals("The patient suffers from a shoulder pain")));
		assertTrue("unable to locate treatment date",
				expectedTreatments.stream().anyMatch(treatment->treatment.getTreatmentDate().equals("9/26/2018")));
	}
	
	@After
	public void after() {
		patientHistory = null;
	}
}
