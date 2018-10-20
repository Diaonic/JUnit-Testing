package medical.com.medicalApplication.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMedication {

	private Medication medication;
	
	@Before
	public void before() {
		medication = new Medication("Sleep","9/25/2018","9/29/2018","8 hrs");
	}
	
	@Test
	public void testGetDose() {
		String expectedValue = "8 hrs";
		String actualValue = medication.getDose();
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testGetEndDate() {
		String expectedValue = "9/29/2018";
		String actualValue = medication.getEndDate();
		assertEquals(expectedValue, actualValue);
	}
	
	@Test 
	public void testGetStartDate() {
		String expectedValue = "9/25/2018";
		String actualValue = medication.getStartDate();
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testGetName() {
		String expectedValue = "Sleep";
		String actualValue = medication.getName();
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testSetDose() {
		medication.setDose("500 mg");
		assertTrue(medication.getDose().equals("500 mg"));
	}
	
	@Test
	public void testSetEndDate() {
		medication.setEndDate("10/29/2018");
		assertTrue(medication.getEndDate().equals("10/29/2018"));
	}
	
	@Test
	public void testSetStartDate() {
		medication.setStartDate("10/25/2018");
		assertTrue(medication.getStartDate().equals("10/25/2018"));
	}
	
	@Test
	public void testSetName() {
		medication.setName("Tylenol");
		assertTrue(medication.getName().equals("Tylenol"));
	}
	
	@Test
	public void testToString() {
		String expectedValue = "Medication:Sleep Start Date: 9/25/2018 End Date: 9/29/2018 Dose: 8 hrs";
		String actualValue = medication.toString();
		assertEquals(expectedValue,actualValue);
	}

	@After
	public void after() {
		medication = null;
	}
}
