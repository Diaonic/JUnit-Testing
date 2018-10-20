package medical.com.medicalApplication.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDoctor {
	private Doctor doctor;
	
	@Before
	public void before() {
		this.doctor = new Doctor("Watson","28");
		assertNotNull("doctor object is null", doctor);
	}
	
	@Test
	public void testGetId() {
		String expectedValue = "28";
		String actualValue = doctor.getId();
		assertNotNull("doctor testId returned a null value", actualValue);
		assertEquals(expectedValue,actualValue);
	}
	
	@Test
	public void testGetName() {
		String expectedValue = "Watson";
		String actualValue = doctor.getName();
		assertNotNull("doctor getName returned a null value", actualValue);
		assertEquals(expectedValue,actualValue);
	}
	
	@Test
	public void testSetId() {
		doctor.setId("11");
		assertTrue(doctor.getId().equals("11"));
	}
	
	@Test
	public void testSetName() {
		doctor.setName("Keenan");
		assertTrue(doctor.getName().equals("Keenan"));
	}
	
	@Test
	//"Doctor Name:"+ name + " ID: "+id
	public void testToString() {
		String expectedValue = "Doctor Name:Watson ID: 28";
		String actualValue = doctor.toString();
		assertNotNull("doctor toString returned a null value", actualValue);
		assertEquals(expectedValue,actualValue);
	}	
	
	@After
	public void after() {
		this.doctor = null;
	}
}
