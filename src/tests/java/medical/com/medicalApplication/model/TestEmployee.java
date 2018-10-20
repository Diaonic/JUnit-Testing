package medical.com.medicalApplication.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestEmployee {

	private Employee employee;
	
	@Before
	public void before() {
		this.employee = new Employee("Alan Turing", "99");
		assertNotNull("employee object is null",employee); 
	}
	
	@Test
	public void testGetId() {
		String expectedValue = "99";
		String actualValue = employee.getId();
		assertNotNull("employee getId returned a null value", actualValue);
		assertEquals(expectedValue,actualValue);
	}
	
	@Test
	public void testGetName() {
		String expectedValue = "Alan Turing";
		String actualValue = employee.getName();
		assertNotNull("employee getName returned a null value", actualValue);
		assertEquals(expectedValue,actualValue);
	}
	
	@Test
	public void testGetPassword() {
		String expectedValue = "Open";
		String actualValue = employee.getPassword();
		assertNotNull("employee getPassword returned a null value", actualValue);
		assertEquals(expectedValue,actualValue);
	}
	
	@After
	public void after() {
		this.employee = null;
	}
}
