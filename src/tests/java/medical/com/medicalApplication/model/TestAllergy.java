package medical.com.medicalApplication.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAllergy {

	private Allergy allergy;
	
	@Before
	public void before(){
		this.allergy = new Allergy("Peanuts");
		assertNotNull("allergy object is null", allergy);
	}
	
	@Test
	public void testSetName() {
		assertTrue(allergy.getName().equals("Peanuts"));
	}
	
	@Test
	public void testToString() {
		String expectedValue = "Allergy " + allergy.getName();
		String actualValue = allergy.toString();
		assertNotNull("allergy toString returned a null value", actualValue);
		assertEquals(expectedValue,actualValue);
	}
	
	@Test
	public void testGetName() {
		String expectedValue = "Peanuts";
		String actualValue = allergy.getName();
		assertNotNull("allergy getName returned a null value", actualValue);
		assertEquals(expectedValue, actualValue);
	}
	
	@After
	public void after() {
		this.allergy = null;
	}
}
