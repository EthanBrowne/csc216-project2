/**
 * 
 */
package edu.ncsu.csc216.stp.model.io;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;
import edu.ncsu.csc216.stp.model.util.SortedList;

/**
 * 
 */
class TestPlanWriterTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.io.TestPlanWriter#TestPlanWriter()}.
	 */
	@Test
	void testTestPlanWriter() {
		TestPlanWriter tpw = new TestPlanWriter();
		File f = new File("");
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> tpw.writeTestPlanFile(f, null));
		assertEquals("Unable to save file.", e1.getMessage());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.io.TestPlanWriter#writeTestPlanFile(java.io.File, edu.ncsu.csc216.stp.model.util.ISortedList)}.
	 */
	@Test
	void testWriteTestPlanFile() {
		TestPlanWriter tpw = new TestPlanWriter();
		File f = new File("test-files/testWriteTestPlanFile");
		ISortedList<TestPlan> list = new SortedList<TestPlan>();
		TestPlan p1 = new TestPlan("First");
		TestCase tc1 = new TestCase("1", "Red", "Cool", "Fail");
		tc1.addTestResult(false, "fails");
		TestCase tc2 = new TestCase("2", "Blue", "Awesome", "Pass");
		tc2.addTestResult(false, "f1");
		tc2.addTestResult(true, "passsss");
		p1.addTestCase(tc1);
		p1.addTestCase(tc2);
		list.add(p1);
		TestPlan p2 = new TestPlan("Second");
		TestCase tc3 = new TestCase("3", "Green", "bad", "yes");
		tc3.addTestResult(true, "yipee");
		p2.addTestCase(tc3);
		list.add(p2);
		assertDoesNotThrow( () -> tpw.writeTestPlanFile(f, list), "Should not throw exception");
	}

}
