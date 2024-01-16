/**
 * 
 */
package edu.ncsu.csc216.stp.model.test_plans;

import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * Test Plan class
 */
public class TestPlan extends AbstractTestPlan implements Comparable<TestPlan> {
	
	/**
	 * TestPlan Constructor
	 * @param testPlanName the name of the testPlan
	 * @throws Illegal argument exception if invalid name
	 */
	public TestPlan(String testPlanName) {
		super(testPlanName);
		if (testPlanName.toLowerCase().equals("failing tests")) throw new IllegalArgumentException("Invalid name.");
	}

	@Override
	public String[][] getTestCasesAsArray() {
		String [][] list = new String[getTestCases().size()][3];
		for (int i = 0; i < getTestCases().size(); i++) {
			list[i][0] = getTestCase(i).getTestCaseId();
			list[i][1] = getTestCase(i).getTestType();
			list[i][2] = getTestCase(i).getStatus();
		}
		return list;
	}
	
	@Override
	public void addTestCase(TestCase testCase) {
		super.addTestCase(testCase);
		testCase.setTestPlan(this);
	}
	
	@Override
	public int compareTo(TestPlan testPlan) {
		return getTestPlanName().toLowerCase().compareTo(testPlan.getTestPlanName().toLowerCase());
	}

}
