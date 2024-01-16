/**
 * 
 */
package edu.ncsu.csc216.stp.model.io;

import java.io.File;
import java.io.PrintStream;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.util.ISortedList;

/**
 * TestPlanWriter Class
 */
public class TestPlanWriter {
	/**
	 * Constructs a TestPlanWriter
	 */
	public TestPlanWriter() {
		//Empty
	}
	
	/**
	 * Writes a list of testPlans to a given file
	 * @param file the file to export to
	 * @param list the list of TestPlans to export
	 * @throws IllegalArgumentException if unable to save to file
	 */
	public static void writeTestPlanFile(File file, ISortedList<TestPlan> list) {
		PrintStream fileWriter;
		try {
			fileWriter = new PrintStream(file);
		} catch (Exception e) {
			throw new IllegalArgumentException("Unable to save file.");
		}
		
		for (int i = 0; i < list.size(); i++) {
			fileWriter.println("! " + list.get(i).getTestPlanName());
			for (int j = 0; j < list.get(i).getTestCases().size(); j++) {
				fileWriter.println(list.get(i).getTestCase(j).toString());
			}
		}
		fileWriter.close();
	}
}
