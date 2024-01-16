/**
 * 
 */
package edu.ncsu.csc216.stp.model.test_plans;

import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * Failing Test List Class
 */
public class FailingTestList extends AbstractTestPlan {
	/** Constant holding the name of the Failing Tests list*/
	public static final String FAILING_TEST_LIST_NAME = "Failing Tests";

	/**
	 * Constructs a Failing Test list
	 */
	public FailingTestList() {
		super(FAILING_TEST_LIST_NAME);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void addTestCase(TestCase t) {
		if (!t.isTestCasePassing()) {
			super.addTestCase(t);
		} else {
			throw new IllegalArgumentException("Cannot add passing test case.");
		}
		
	}
	
	@Override
	public void setTestPlanName(String testPlanName) {
		if (testPlanName != FAILING_TEST_LIST_NAME) {
			throw new IllegalArgumentException("The Failing Tests list cannot be edited.");
		}
		super.setTestPlanName(testPlanName);
	}

	@Override
	public String[][] getTestCasesAsArray() {
		String[][] testCases = new String[getTestCases().size()][3];
		for (int i = 0; i < getTestCases().size(); i++) {
			testCases[i][0] = getTestCase(i).getTestCaseId();
			testCases[i][1] = getTestCase(i).getTestType();
			try {
				testCases[i][2] = getTestCase(i).getTestPlan().getTestPlanName();
			} catch (Exception e) {
				testCases[i][2] = "";
			}
		}
			
		return testCases;
	}
	
	/**
	 * Clears the FailingTestList of all TestCases
	 */
	public void clearTests() {
		for (int i = 0; i < getTestCases().size(); i = i + 0) {
			removeTestCase(i);
		}
	}

}
