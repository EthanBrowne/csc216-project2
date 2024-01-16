/**
 * 
 */
package edu.ncsu.csc216.stp.model.test_plans;

import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISwapList;
import edu.ncsu.csc216.stp.model.util.SwapList;

/**
 * The AbstractTestPlan class
 */
public abstract class AbstractTestPlan {
	/** The name of the test plan */
	private String testPlanName;
	/** List of TestCases */
	private ISwapList<TestCase> testCases;
	
	/**
	 * The Constructor of the AbstractTestPlan
	 * @param testPlanName the name of the test plan
	 * @throws IllegalArgumentException if Invalid Name
	 */
	public AbstractTestPlan(String testPlanName) {
		setTestPlanName(testPlanName);
		testCases = new SwapList<TestCase>();
	}

	/**
	 * Returns the testPlanName
	 * @return the testPlanName the name of the test plan
	 */
	public String getTestPlanName() {
		return testPlanName;
	}

	/**
	 * Sets the testPlan name
	 * @param testPlanName the testPlanName to set
	 * @throws IllegalArgumentException if Invalid Name
	 */
	public void setTestPlanName(String testPlanName) {
		if (testPlanName == null || testPlanName.length() == 0) {
			throw new IllegalArgumentException("Invalid name.");
		}
		this.testPlanName = testPlanName;
	}

	/**
	 * Returns the list of testCases
	 * @return the testCases list
	 */
	public ISwapList<TestCase> getTestCases() {
		return testCases;
	}
	
	/**
	 * Adds the TestCase to the testCase list
	 * @param testCase the test case to add
	 */
	public void addTestCase(TestCase testCase) {
		testCases.add(testCase);
	}
	
	/**
	 * Removes a test case at an index
	 * @param idx index of removal
	 * @return test case at the index
	 */
	public TestCase removeTestCase(int idx) {
		return testCases.remove(idx);
	}
	
	/**
	 * Returns a test case at an index
	 * @param idx index of return
	 * @return test case at the index
	 */
	public TestCase getTestCase(int idx) {
		return testCases.get(idx);
	}
	
	/**
	 * Gets the number of failing tests
	 * @return number of failing tests
	 */
	public int getNumberOfFailingTests() {
		int f = 0;
		for (int i = 0; i < testCases.size(); i++) {
			if (!testCases.get(i).isTestCasePassing()) {
				f++;
			}
		}
		return f;
	}
	
	/**
	 * Adds the test results
	 * @param idx the index of the test result
	 * @param passing whether the test is passing
	 * @param actualResults the actual result of the test
	 */
	public void addTestResult(int idx, boolean passing, String actualResults) {
		testCases.get(idx).addTestResult(passing, actualResults);
	}
	
	/**
	 * Returns Two dimensional string array represented by test cases
	 * @return String[][] of test cases
	 */
	public abstract String[][] getTestCasesAsArray();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((testPlanName == null) ? 0 : testPlanName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractTestPlan other = (AbstractTestPlan) obj;
		if (testPlanName == null) {
			if (other.testPlanName != null)
				return false;
		} else if (!testPlanName.equals(other.testPlanName))
			return false;
		return true;
	}
	
	
}
