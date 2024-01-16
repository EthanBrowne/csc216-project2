/**
 * 
 */
package edu.ncsu.csc216.stp.model.io;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

/**
 * 
 */
class TestPlanReaderTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.io.TestPlanReader#TestPlanReader()}.
	 */
	@Test
	void testTestPlanReader() {
		TestPlanReader tpr = new TestPlanReader();
		File f = new File("");
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> tpr.readTestPlansFile(f));
		assertEquals("Unable to load file.", e1.getMessage());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.io.TestPlanReader#readTestPlansFile(java.io.File)}.
	 */
	@Test
	void testReadTestPlansFile() {
		fail();
//		TestPlanReader tpr = new TestPlanReader();
//		File f = new File("test-files/testWriteTestPlanFile");
//		assertDoesNotThrow( () -> tpr.readTestPlansFile(f), "Should not throw exception");
	}

}
