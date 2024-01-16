/**
 * 
 */
package edu.ncsu.csc216.stp.model.tests;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.util.ILog;
import edu.ncsu.csc216.stp.model.util.Log;

/**
 * Test Case class
 */
public class TestCase {
	/** The ID of the test case */
	private String testCaseId;
	/** the type of the test case */
	private String testType;
	/** the description of the test case */
	private String testDescription;
	/** the expected results of the test case */
	private String expectedResults;
	/** TestPlan that the Test Case belongs to*/
	private TestPlan testPlan;
	/** List of the test results */
	private ILog<TestResult> testResults;
	
	/**
	 * TestCase Constructor
	 * @param testCaseId the testCase id
	 * @param testType the testCase type
	 * @param testDescription the testCase description
	 * @param expectedResults the testCase expected results
	 */
	public TestCase(String testCaseId, String testType, String testDescription, String expectedResults) {
		testResults = new Log<TestResult>();
		setTestCaseId(testCaseId);
		setTestType(testType);
		setTestDescription(testDescription);
		setExpectedResults(expectedResults);
	}
	
	/**
	 * gets the test case id
	 * 
	 * @return testCaseId the id of the testCase
	 */
	public String getTestCaseId() {
		return testCaseId;
	}
	
	/**
	 * sets the test case id
	 * 
	 * @param id the id to set the test case id to
	 * @throws IllegalArgumentException if it is an empty string
	 */
	private void setTestCaseId(String id) {
		if (id == null || id.length() == 0) {
			throw new IllegalArgumentException("Invalid test information.");
		}
		this.testCaseId = id;
	}
	
	/**
	 * returns the Testtype 
	 * 
	 * @return testType the type of the Test
	 */
	public String getTestType() {
		return testType;
	}
	
	/**
	 * sets the test type of the test case
	 * 
	 * @param type the type to set the test case to
	 * @throws IllegalArgumentException if it is an empty string
	 */
	private void setTestType(String type) {
		if (type == null || type.length() == 0) {
			throw new IllegalArgumentException("Invalid test information.");
		}
		this.testType = type;
	}
	
	/**
	 * gets the test description
	 * 
	 * @return testDescription the description of the testCase
	 */
	public String getTestDescription(){
		return testDescription;
	}
	
	/**
	 * sets the test description
	 * 
	 * @param description the description to set the test case description to
	 * @throws IllegalArgumentException if it is an empty string
	 */
	private void setTestDescription(String description) {
		if (description == null || description.length() == 0) {
			throw new IllegalArgumentException("Invalid test information.");
		}
		this.testDescription = description;
	}
	
	/**
	 * gets the expected results of the test case
	 * 
	 * @return expectedResults the expected results of the testCase
	 */
	public String getExpectedResults() {
		return expectedResults;
	}
	
	/**
	 * sets the expected results of the test case
	 * 
	 * @param results the expected results of the testCase
	 * @throws IllegalArgumentException if it is an empty string
	 */
	private void setExpectedResults(String results) {
		if (results == null || results.length() == 0) {
			throw new IllegalArgumentException("Invalid test information.");
		}
		this.expectedResults = results;
	}
	
	/**
	 * adds a test results to the test case
	 * 
	 * @param ispassing whether or not the test case is passing
	 * @param actualResults the actual results of the test case
	 * @throws IllegalArgumentException if constructing testResult throws exception
	 */
	public void addTestResult(boolean ispassing, String actualResults) {
		TestResult t = new TestResult(ispassing, actualResults);
		testResults.add(t);
	}
	
	/**
	 * returns true if the test case is passing
	 * 
	 * @return true if the test case is passing
	 */
	public boolean isTestCasePassing() {
		if (testResults.size() == 0) {
			return false;
		} else {
		return testResults.get(testResults.size() - 1).isPassing();
		}
	}	
	
	/**
	 * returns the status of the test case as either "PASS" or "FAIL"
	 * 
	 * @return the status of the testCase, either "PASS" or "FAIL"
	 */
	public String getStatus() {
		if (isTestCasePassing()) {
			return "PASS";
		}
		return "FAIL";
	}
	
	/**
	 * returns a String representation of the test results log
	 * 
	 * @return String representation of the test results log
	 */
	public String getActualResultsLog() {
		String s = "";
		for (int i = 0; i < testResults.size(); i++) {
			s = s + "- " + testResults.get(i).toString() + "\n";
		}
		s = s.substring(0,s.length()-1);
		return s;
	}
	
	/**
	 * sets the test plan field to the given parameters
	 * 
	 * @param testPlan the test plan to set the testplan field
	 * @throws IllegalArgumentException if it is invalid
	 */
	public void setTestPlan(TestPlan testPlan) {
		if (testPlan == null) {
			throw new IllegalArgumentException("Invalid test plan.");
		}
		this.testPlan = testPlan;
	}
	
	/**
	 * gets the testPlan field
	 * 
	 * @return the testPlan field
	 */
	public TestPlan getTestPlan() {
		return testPlan;
		
	}
	
	/**
	 * returns a string representation of the Test case
	 * 
	 * @return string representation of the Test case
	 */
	public String toString() {
		String s = "# " + testCaseId + "," + testType + "\n" + testDescription + "\n" + expectedResults + "\n" + getActualResultsLog();
		return s;
	}
}
