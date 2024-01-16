/**
 * 
 */
package edu.ncsu.csc216.stp.model.io;

import java.io.File;
import java.util.Scanner;

import edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan;
import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;
import edu.ncsu.csc216.stp.model.util.SortedList;

/**
 * TestPlanReader Class
 */
public class TestPlanReader {
	/**
	 * Constructs a TestPlanReader
	 */
	public TestPlanReader() {
		//Empty
	}
	
	/**
	 * Reads TestPlans and TestCases from a file and imports them
	 * @param file the file to read from
	 * @throws IllegalArgumentException if unable to read from file
	 * @return a Sorted List of TestPlans read from the file
	 */
	public static ISortedList<TestPlan> readTestPlansFile(File file){
		Scanner fileReader;
		String fileString = "";
		ISortedList<TestPlan> list = new SortedList<TestPlan>();;
		try {
			fileReader = new Scanner(file);
		} catch (Exception e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		while (fileReader.hasNextLine()) {
			fileString = fileString + fileReader.nextLine() + "\n";
		}
		fileReader.close();
		Scanner lineReader = new Scanner(fileString);
		lineReader.useDelimiter("\\r?\\n?[!] ");
		while (lineReader.hasNext()) {
			try {
				list.add(processTestPlan(lineReader.next()));;
			} catch (Exception e) {
				throw new IllegalArgumentException("Error");
			}
		}
		lineReader.close();
		return list;
	}
	
	/**
	 * Returns a testPlan given a string
	 * @param testPlanString String containing the testPlan that must be read
	 * @return a TestPlan that is processed
	 */
	private static TestPlan processTestPlan(String testPlanString) {
		Scanner processor = new Scanner(testPlanString);
		processor.useDelimiter("\n");
		TestPlan testPlan = new TestPlan(processor.next());
		processor.useDelimiter("\\r?\\n?[#] ");
		while (processor.hasNext()) {
			testPlan.addTestCase(processTest(testPlan, testPlanString));
		}
		processor.close();
		return testPlan;
	}
	
	/**
	 * Returns a test case given a string containing the test case
	 * @param testPlan the test Plan
	 * @param testCaseString the string containing the testCase
	 * @return a TestCase that is processed
	 */
	private static TestCase processTest(AbstractTestPlan testPlan, String testCaseString) {
		TestCase t;
		Scanner processor = new Scanner(testCaseString);
		processor.useDelimiter(",");
		String testCaseId;
		String testType;
		String testDescription;
		String expectedResults;
		try {
			testCaseId = processor.next();
			processor.useDelimiter("\n* ");
			testType = processor.next();
			testDescription = processor.next();
			processor.useDelimiter("\n- ");
			if (processor.hasNext()) {
				expectedResults = processor.next();
				t = new TestCase(testCaseId, testType, testDescription, expectedResults);
				while (processor.hasNext()) {
					processor.useDelimiter(": ");
					boolean passing = processor.next().equals("PASSING");
					processor.useDelimiter("\n- ");
					String details = processor.next();
					t.addTestResult(passing, details);
				}
			} else {
				processor.useDelimiter("\r");
				expectedResults = processor.next();
				t = new TestCase(testCaseId, testType, testDescription, expectedResults);
			}
			processor.close();
			return t;
		}catch (Exception e) {
			throw new IllegalArgumentException("Invaid Data");
		}
	}
}
