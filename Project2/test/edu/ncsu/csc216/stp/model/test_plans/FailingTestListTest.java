package edu.ncsu.csc216.stp.model.test_plans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.tests.TestCase;

class FailingTestListTest {

	@Test
	void test() {
		FailingTestList f = new FailingTestList();
		TestCase t1 = new TestCase("1", "Brawl StARs", "Hi", "nothing");
		t1.addTestResult(false, "something");
		TestCase t2 = new TestCase("342234", "Bawl StARs", "Hi", "nothing");
		t2.addTestResult(true, "something");
		f.addTestCase(t1);
		assertEquals(f.getTestCasesAsArray()[0][0], "1");
		Exception e3 = assertThrows(IllegalArgumentException.class, () -> f.addTestCase(t2));
		assertEquals(e3.getMessage(), "Cannot add passing test case."); 	
		
		Exception e4 = assertThrows(IllegalArgumentException.class, () -> f.setTestPlanName("hi"));
		assertEquals(e4.getMessage(), "The Failing Tests list cannot be edited."); 
	}

}
