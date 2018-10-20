package medical.com.medicalApplication.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPatient {
	
	private Patient patient;
	
	@Before
	public void before() {
		patient = new Patient("Joe", "1234");
	}
	
	@Test
	public void testGetId() {
		String expectedValue = "1234";
		String actualValue = patient.getId();
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testGetName() {
		String expectedValue = "Joe";
		String actualValue = patient.getName();
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testSetId() {
		patient.setId("5678");
		assertTrue(patient.getId().equals("5678"));
	}
	
	@Test
	public void testSetName() {
		patient.setName("Daniel");
		assertTrue(patient.getName().equals("Daniel"));
	}
	
	@Test
	public void testToString() {
		//"Patient Name: "+name+ " ID: "+id;
		String expectedValue = "Patient Name: Joe ID: 1234";
		String actualValue = patient.toString();
		assertEquals(expectedValue, actualValue);
	}
	
	@After
	public void after() {
		patient = null;
	}

}
