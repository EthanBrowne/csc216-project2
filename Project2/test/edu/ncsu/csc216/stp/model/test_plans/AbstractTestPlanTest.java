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
class AbstractTestPlanTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan#hashCode()}.
	 */
	@Test
	void testHashCode() {
		AbstractTestPlan t = new TestPlan("Yuh");
		AbstractTestPlan t1 = new TestPlan("Yuh");
		AbstractTestPlan t2 = new TestPlan("dfghvacklJAGEVFDWHb");
		assertEquals(t.hashCode(), t1.hashCode());
		assertEquals(t1.hashCode(), t.hashCode());
		assertEquals(t1.hashCode(), t1.hashCode());
		assertNotEquals(t2.hashCode(), t1.hashCode());
		assertNotEquals(t2.hashCode(), t.hashCode());
		assertNotEquals(t1.hashCode(), t2.hashCode());
		assertNotEquals(t.hashCode(), t2.hashCode());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan#AbstractTestPlan(java.lang.String)}.
	 */
	@Test
	void testAbstractTestPlan() {
		AbstractTestPlan t = new TestPlan("Yuh");
		assertEquals("Yuh", t.getTestPlanName());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan#getTestPlanName()}.
	 */
	@Test
	void testGetTestPlanName() {
		AbstractTestPlan t = new TestPlan("Yuh");
		assertEquals("Yuh", t.getTestPlanName());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan#setTestPlanName(java.lang.String)}.
	 */
	@Test
	void testSetTestPlanName() {
		AbstractTestPlan t = new TestPlan("Yuh");
		assertEquals("Yuh", t.getTestPlanName());
		t.setTestPlanName("Cuh");
		assertEquals("Cuh", t.getTestPlanName());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan#getTestCases()}.
	 */
	@Test
	void testGetTestCases() {
		AbstractTestPlan t = new TestPlan("Yuh");
		TestCase c1 = new TestCase("1", "fortnite", "awesome sauce", "yes");
		TestCase c2 = new TestCase("2", "bye", "hi", "no");
		t.addTestCase(c1);
		t.addTestCase(c2);
		assertEquals(t.getTestCases().get(0).getTestCaseId(), "1");
		assertEquals(t.getTestCases().get(1).getTestCaseId(), "2");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan#addTestCase(edu.ncsu.csc216.stp.model.tests.TestCase)}.
	 */
	@Test
	void testAddTestCase() {
		AbstractTestPlan t = new TestPlan("Yuh");
		TestCase c1 = new TestCase("1", "fortnite", "awesome sauce", "yes");
		TestCase c2 = new TestCase("2", "bye", "hi", "no");
		t.addTestCase(c1);
		t.addTestCase(c2);
		assertEquals(t.getTestCases().get(0).getTestCaseId(), "1");
		assertEquals(t.getTestCases().get(1).getTestCaseId(), "2");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan#removeTestCase(int)}.
	 */
	@Test
	void testRemoveTestCase() {
		AbstractTestPlan t = new TestPlan("Yuh");
		TestCase c1 = new TestCase("1", "fortnite", "awesome sauce", "yes");
		t.addTestCase(c1);
		assertEquals(t.getTestCases().get(0).getTestCaseId(), "1");
		assertEquals("1", t.removeTestCase(0).getTestCaseId());
		assertEquals(t.getTestCases().size(), 0);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan#getTestCase(int)}.
	 */
	@Test
	void testGetTestCase() {
		AbstractTestPlan t = new TestPlan("Yuh");
		TestCase c1 = new TestCase("1", "fortnite", "awesome sauce", "yes");
		t.addTestCase(c1);
		assertEquals("1", t.getTestCase(0).getTestCaseId());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan#getNumberOfFailingTests()}.
	 */
	@Test
	void testGetNumberOfFailingTests() {
		AbstractTestPlan t = new TestPlan("Yuh");
		TestCase c1 = new TestCase("1", "fortnite", "awesome sauce", "yes");
		TestCase c2 = new TestCase("2", "bye", "hi", "no");
		c1.addTestResult(false, "4545");
		c2.addTestResult(false, "22345");
		t.addTestCase(c1);
		t.addTestCase(c2);
		assertEquals(2, t.getNumberOfFailingTests());
		c1.addTestResult(true, "uadiwjnwa");
		assertEquals(1, t.getNumberOfFailingTests());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan#addTestResult(int, boolean, java.lang.String)}.
	 */
	@Test
	void testAddTestResult() {
		AbstractTestPlan t = new TestPlan("Yuh");
		TestCase c1 = new TestCase("1", "fortnite", "awesome sauce", "yes");
		TestCase c2 = new TestCase("2", "bye", "hi", "no");
		t.addTestCase(c1);
		t.addTestCase(c2);
		t.addTestResult(0, false, "kjkndajwndkjawbnd");
		t.addTestResult(1, false, "oajwndlajkwndlanwd");
		assertEquals(2, t.getNumberOfFailingTests());
		t.addTestResult(0, true, "isubfiusebf");
		assertEquals(1, t.getNumberOfFailingTests());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject() {
		AbstractTestPlan t = new TestPlan("Yuh");
		AbstractTestPlan t1 = new TestPlan("Yuh");
		AbstractTestPlan t2 = new TestPlan("dfghvacklJAGEVFDWHb");
		assertEquals(t, t1);
		assertNotEquals(t, t2);
	}

}

