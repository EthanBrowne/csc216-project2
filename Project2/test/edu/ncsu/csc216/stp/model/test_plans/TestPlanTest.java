/**
 * 
 */
package edu.ncsu.csc216.stp.model.test_plans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * 
 */
class TestPlanTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.test_plans.TestPlan#addTestCase(edu.ncsu.csc216.stp.model.tests.TestCase)}.
	 */
	@Test
	void testAddTestCase() {
		TestPlan t = new TestPlan("test plan");
		TestCase s = new TestCase("2", "Orange", "It tests", "Stuff");
		t.addTestCase(s);
		assertEquals(t.getTestCase(0).getTestType(), s.getTestType());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.test_plans.TestPlan#getTestCasesAsArray()}.
	 */
	@Test
	void testGetTestCasesAsArray() {
		TestPlan t = new TestPlan("test plan");
		TestCase s = new TestCase("2", "Orange", "It tests", "Stuff");
		s.addTestResult(false, "fortnite");
		t.addTestCase(s);
		assertEquals(t.getTestCasesAsArray()[0][0], "2");
		assertEquals(t.getTestCasesAsArray()[0][1], "Orange");
		assertEquals(t.getTestCasesAsArray()[0][2], "FAIL");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.test_plans.TestPlan#TestPlan(java.lang.String)}.
	 */
	@Test
	void testTestPlan() {
		Exception e1 = assertThrows(IllegalArgumentException.class,
				() -> new TestPlan("FaIlInG TEsTs"));
		assertEquals(e1.getMessage(), "Invalid name.");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.test_plans.TestPlan#compareTo(edu.ncsu.csc216.stp.model.test_plans.TestPlan)}.
	 */
	@Test
	void testCompareTo() {
		TestPlan t = new TestPlan("a");
		TestPlan t1 = new TestPlan("a");
		assertEquals(0, t.compareTo(t1));
		
		TestPlan t2 = new TestPlan("b");
		assertEquals(-1, t.compareTo(t2));
		assertEquals(1, t2.compareTo(t));
	}

}
