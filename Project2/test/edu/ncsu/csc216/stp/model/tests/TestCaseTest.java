/**
 * 
 */
package edu.ncsu.csc216.stp.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;

/**
 * 
 */
class TestCaseTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.tests.TestCase#TestCase(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testTestCase() {
		TestCase s = new TestCase("2", "Orange", "It tests", "Stuff");
		assertNull(s.getTestPlan());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.tests.TestCase#getTestCaseId()}.
	 */
	@Test
	void testGetTestCaseId() {
		TestCase s = new TestCase("2", "Orange", "It tests", "Stuff");
		assertEquals("2", s.getTestCaseId());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.tests.TestCase#getTestType()}.
	 */
	@Test
	void testGetTestType() {
		TestCase s = new TestCase("2", "Orange", "It tests", "Stuff");
		assertEquals("Orange", s.getTestType());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.tests.TestCase#getTestDescription()}.
	 */
	@Test
	void testGetTestDescription() {
		TestCase s = new TestCase("2", "Orange", "It tests", "Stuff");
		assertEquals("It tests", s.getTestDescription());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.tests.TestCase#getExpectedResults()}.
	 */
	@Test
	void testGetExpectedResults() {
		TestCase s = new TestCase("2", "Orange", "It tests", "Stuff");
		assertEquals("Stuff", s.getExpectedResults());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.tests.TestCase#addTestResult(boolean, java.lang.String)}.
	 */
	@Test
	void testAddTestResult() {
		TestCase s = new TestCase("2", "Orange", "It tests", "Stuff");
		s.addTestResult(false, "no");
		assertFalse(s.isTestCasePassing());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.tests.TestCase#isTestCasePassing()}.
	 */
	@Test
	void testIsTestCasePassing() {
		TestCase s = new TestCase("2", "Orange", "It tests", "Stuff");
		s.addTestResult(false, "no");
		assertFalse(s.isTestCasePassing());
		s.addTestResult(true, "yes");
		assertTrue(s.isTestCasePassing());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.tests.TestCase#getStatus()}.
	 */
	@Test
	void testGetStatus() {
		TestCase s = new TestCase("2", "Orange", "It tests", "Stuff");
		s.addTestResult(false, "no");
		assertFalse(s.isTestCasePassing());
		assertEquals("FAIL", s.getStatus());
		s.addTestResult(true, "yes");
		assertTrue(s.isTestCasePassing());
		assertEquals("PASS", s.getStatus());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.tests.TestCase#getActualResultsLog()}.
	 */
	@Test
	void testGetActualResultsLog() {
		TestCase s = new TestCase("2", "Orange", "It tests", "Stuff");
		s.addTestResult(false, "no");
		assertEquals("- FAIL: no", s.getActualResultsLog());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.tests.TestCase#setTestPlan(edu.ncsu.csc216.stp.model.test_plans.TestPlan)}.
	 */
	@Test
	void testSetTestPlan() {
		TestCase s = new TestCase("2", "Orange", "It tests", "Stuff");
		assertNull(s.getTestPlan());
		TestPlan p = new TestPlan("t");
		s.setTestPlan(p);
		assertEquals("t", s.getTestPlan().getTestPlanName());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.tests.TestCase#getTestPlan()}.
	 */
	@Test
	void testGetTestPlan() {
		TestCase s = new TestCase("2", "Orange", "It tests", "Stuff");
		assertNull(s.getTestPlan());
		TestPlan p = new TestPlan("t");
		s.setTestPlan(p);
		assertEquals("t", s.getTestPlan().getTestPlanName());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.tests.TestCase#toString()}.
	 */
	@Test
	void testToString() {
		TestCase s = new TestCase("2", "Orange", "It tests", "Stuff");
		s.addTestResult(false, "no");
		assertEquals("# 2,Orange\nIt tests\nStuff\n- FAIL: no", s.toString());
	}

}
