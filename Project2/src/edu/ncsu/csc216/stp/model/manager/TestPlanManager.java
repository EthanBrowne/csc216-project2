/**
 * 
 */
package edu.ncsu.csc216.stp.model.manager;

import java.io.File;

import edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan;
import edu.ncsu.csc216.stp.model.test_plans.FailingTestList;
import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;
import edu.ncsu.csc216.stp.model.util.SortedList;

/**
 * The TestPlan Manager Class
 */
public class TestPlanManager {
	/** whether or not the test plan is changed*/
	private boolean isChanged;
	/** the list of Test Plans in the Manager */
	private ISortedList<TestPlan> testPlans;
	/** the list of failing Test Cases in all of the Test Plans in the Manager */
	private FailingTestList failingTestList;
	/** The current test plan that is being modified */
	private AbstractTestPlan currentTestPlan;
	
	/**
	 * Constructor for TestPlanManager
	 */
	public TestPlanManager(){
		failingTestList = new FailingTestList();
		clearTestPlans();
	}
	
	/**
	 * load the file and return a list of potential TestPlans to add to the list of TestPlans
	 * @param testPlanFile the file to load the TestPlans from
	 */
	public void loadTestPlans(File testPlanFile) {
		//TODO
	}
	
	/**
	 * saves the current TsetPlan to the given file
	 * 
	 * @param testPlanFile file to save the current test plan to
	 */
	public void saveTestPlans(File testPlanFile) {
		//TODO
	}
	
	/**
	 * Returns the isChanged field
	 * @return isChanged whether or not the test plan is changed
	 */
	public boolean isChanged() {
		return isChanged;
	}
	
	/**
	 * adds a new TestPlan
	 * 
	 * @param testPlanName the name of the testPlan
	 * @throws IllegalArgumentException if it is invalid TODO
	 */
	public void addTestPlan(String testPlanName) {
		if (testPlanName.toLowerCase().equals("failing tests")) {
			throw new IllegalArgumentException("Invalid name.");
		}
		for (int i = 0; i < testPlans.size(); i++) {
			if (testPlans.get(i).getTestPlanName().equals(testPlanName)) {
				throw new IllegalArgumentException("Invalid name.");
			}
		}
		TestPlan t = new TestPlan(testPlanName);
		testPlans.add(t);
		setCurrentTestPlan(testPlanName);
		isChanged = true;
	}
	
	/**
	 * returns a list of test plan names with the failing test being listed first
	 * @return names String list of the names of the test plans
	 */
	public String[] getTestPlanNames() {
		String[] names = new String[1 + testPlans.size()];
		names[0] = failingTestList.getTestPlanName();
		for (int i = 1; i < testPlans.size() + 1; i++) {
			names[i] = testPlans.get(i).getTestPlanName();
		}
		return names;
	}

	/**
	 * Private helper method
	 * gets the FailingTestList
	 */
	private void getFailingTests() {
		TestPlan current;
		failingTestList.clearTests();
		for (int i = 0; i < testPlans.size(); i++) {
			current = testPlans.get(i);
			for (int j = 0; j < current.getTestCases().size(); j++) {
				if (!current.getTestCases().get(j).isTestCasePassing()) {
					failingTestList.addTestCase(current.getTestCases().get(j));
				}
			}
		}
	}
	
	/**
	 * sets the CurrentTestPlan to the AbstractTestPlan with the given name
	 * 
	 * @param testPlanName name to set the c=CurrentTestPlan to
	 */
	public void setCurrentTestPlan(String testPlanName) {
		boolean found = false;
		for (int i = 0; i < testPlans.size(); i++) {
			if(testPlans.get(i).getTestPlanName().equals(testPlanName)) {
				currentTestPlan = testPlans.get(i);
				found = true;
			}
		}
		
		if (!found) {
			getFailingTests();
			currentTestPlan = failingTestList;
		}
		
	}
	
	/**
	 * gets the currentTestPlan
	 * 
	 * @return current test plan
	 */
	public AbstractTestPlan getCurrentTestPlan() {
		return currentTestPlan;
	}
	
	/**
	 *edits the current testPlan to the testPlanName parameter 
	 * 
	 * @param testPlanName the name to change the currentTestPlan to
	 * @throws IllegalArgumentException if it is invalid TODO
	 */
	public void editTestPlan(String testPlanName) {
		if (currentTestPlan.equals(failingTestList)) {
			throw new IllegalArgumentException("The Failing Tests list may not be edited.");
		}
		if (testPlanName.toLowerCase().equals("Failing Tests".toLowerCase())) {
			throw new IllegalArgumentException("Invalid name.");
		}
		for (int i = 0; i < testPlans.size(); i++) {
			if (testPlans.get(i).getTestPlanName().equals(testPlanName)) {
				throw new IllegalArgumentException("Invalid name.");
			}
		}
		for (int i = 0; i < testPlans.size(); i++) {
			if (testPlans.get(i).getTestPlanName().equals(currentTestPlan.getTestPlanName())){
				TestPlan temp = testPlans.get(i);
				testPlans.remove(i);
				temp.setTestPlanName(testPlanName);
				testPlans.add(temp);
			}
		}
		currentTestPlan.setTestPlanName(testPlanName);
		isChanged = true;
		

	}
	
	/**
	 * removes the currentTestPlan
	 * 
	 * @throws IllegalArgumentException if the currentTestPlan is an FailingTestList
	 * @throws IllegalArgumentException if it is invalid TODO
	 */
	public void removeTestPlan() {
		if (currentTestPlan.equals(failingTestList)) {
			throw new IllegalArgumentException("The Failing Tests list may not be deleted.");
		}
		for (int i = 0; i < testPlans.size(); i++) {
			if (testPlans.get(i).getTestPlanName().equals(currentTestPlan.getTestPlanName())){
				testPlans.remove(i);
			}
		}
		getFailingTests();
		currentTestPlan = failingTestList;
		isChanged = true;
	}
	
	/**
	 * adds a TestCase to the TestPlan
	 * 
	 * @param t the TestCase being added
	 */
	public void addTestCase(TestCase t) {
		if (currentTestPlan instanceof TestPlan) {
			currentTestPlan.addTestCase(t);
			if (!t.isTestCasePassing()) {
				getFailingTests();
			}
			isChanged = true;
		}
	}
	
	/**
	 * adds the test result to the test case at the given index in the current test plan
	 * 
	 * @param idx the index to add the test result
	 * @param passing whether or not the test case is passing
	 * @param actualResult the actual result of the test case
	 */
	public void addTestResult(int idx, boolean passing, String actualResult) {
		currentTestPlan.addTestResult(idx, passing, actualResult);
		if (!passing) {
			getFailingTests();
		}
	}
	
	/**
	 * Clears the TestPlanManager and sets testPlans to an empty SortedList
	 */
	public void clearTestPlans() {
		isChanged = false;
		testPlans = new SortedList<TestPlan>();
		failingTestList.clearTests();
	}
}
