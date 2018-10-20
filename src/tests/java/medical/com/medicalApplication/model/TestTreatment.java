package medical.com.medicalApplication.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestTreatment {

	private Treatment treatment;
	@Before
	public void before() {
		treatment = new Treatment("12/1/2018","Patient suffers from headache","Over the counter meds will cure");
	}
	
	@Test
	public void testTreatmentConstructor() {
		Treatment treatment = new Treatment("9/26/2018","Patient experiencing nausea","Take some Antiemetic medication");
		assertTrue(treatment != null);
	}
	
	@Test
	public void testGetDescription() {
		//arrange
		String expectedDescription = "Over the counter meds will cure";
		//act
		String actualDescription = treatment.getDescription();
		//assert
		assertTrue("Treatment description is null",actualDescription != null);
		assertEquals("Expected description does not match actual description",
				expectedDescription, actualDescription);
	}
	
	@Test
	public void testGetDiagnose() {
		//arrange
		Treatment treatmentDiagnose = new Treatment("startDate","Patient experiencing nausea","description");
		String expectedDiagnose = "Patient experiencing nausea";
		//act
		String actualDiagnose = treatmentDiagnose.getDiagnose();
		//assert
		assertTrue("Diagnose is null",actualDiagnose != null);
		assertEquals("Expected diagnose does not match actual diagnose",
				expectedDiagnose, actualDiagnose);		
	}
	
	@Test
	public void testGetTreatmentDate() {		
		//arrange
		Treatment treatmentDate = new Treatment("12/1/2018","diagnose","description");
		String expectedTreatmentDate = "12/1/2018";
		//act
		String actualTreatmentDate = treatmentDate.getTreatmentDate();
		//assert
		assertTrue("Treatment Date is null",actualTreatmentDate != null);
		assertEquals("Expected treatment date does not match actual treatment date",
				expectedTreatmentDate,actualTreatmentDate);
	}
	
	@Test
	public void testSetDescription() {
		//arrange
		String expectedDescription = "New Description";	
		//act
		treatment.setDescription(expectedDescription);
		String actualDescription = treatment.getDescription();
		//assert
		assertTrue("actual description is null",actualDescription !=null);
		assertEquals("set description values do not match",expectedDescription,actualDescription);
	}
	
	@Test
	public void testSetDiagnose() {
		//arrange
		String expectedDiagnose = "New Diagnose";	
		//act
		treatment.setDiagnose(expectedDiagnose);
		String actualDiagnose = treatment.getDiagnose();
		//assert
		assertTrue("actual diagnose is null",actualDiagnose !=null);
		assertEquals("set description values do not match",expectedDiagnose,actualDiagnose);
	}
	
	@Test
	public void testSetTreatmentDate() {
		//arrange
		String expectedTreatmentDate = "11/11/2021";	
		//act
		treatment.setTreatmentDate(expectedTreatmentDate);
		String actualTreatmentDate = treatment.getTreatmentDate();
		//assert
		assertTrue("actual treatment date is null",actualTreatmentDate !=null);
		assertEquals("set treatment date values do not match",expectedTreatmentDate,actualTreatmentDate);
	}
	
	@Test
	public void testToString() {
		//return "Treatment:"+ description + " Date: "+ treatmentDate+ " Diagnose: " + diagnose;
		//arrange
		String expectedValue = 
				"Treatment:Over the counter meds will cure Date: 12/1/2018 Diagnose: Patient suffers from headache";
		//act
		String actualValue = treatment.toString();
		//assert
		assertTrue("treatment toString is null", actualValue != null);
		assertEquals("expected toString value does not match actual toString value",expectedValue, actualValue);
	}
	
	@After
	public void after() {
		treatment = null;
	}

}
