/**
 * 
 */
package edu.ncsu.csc216.stp.model.tests;

/**
 * The test result class
 */
public class TestResult {
	/** String Constant that represents a passing test*/
	public static final String PASS = "PASS";
	/** String Constant that represents a failing test*/
	public static final String FAIL = "FAIL";
	/** Boolean field that represents whether a test is passing*/
	private boolean passing;
	/** String field of the actual results of the test*/
	private String actualResults;
	
	/**
	 * Constructor for TestResult
	 * 
	 * @param passing whether or not the test is passing
	 * @param actualResults the actual results of the test
	 */
	public TestResult(boolean passing, String actualResults){
		setPassing(passing);
		setActualResults(actualResults);
	}
	
	/**
	 * returns the actual results of the test
	 * 
	 * @return actual results of the test
	 */
	public String getActualResults() {
		return this.actualResults;
	}
	
	/**
	 * sets the actual results of the test
	 * 
	 * @param actualResults the results of the tests
	 * @throws IllegalArgumentException if it is an empty string
	 */
	private void setActualResults(String actualResults) {
		if (actualResults == null) {
			throw new IllegalArgumentException();
		}
		this.actualResults = actualResults;
	}
	
	/**
	 * returns true if the tests is passing
	 * 
	 * @return passing the boolean that represents if the test passed
	 */
	public boolean isPassing() {
		return passing;
	}
	
	/**
	 * sets whether or not the test is passing
	 * 
	 * @param passing whether the test passes
	 */
	private void setPassing(boolean passing) {
		this.passing = passing;
	}
	
	/**
	 * returns a string representation of TestResult.
	 * @return string representation of the TestResult
	 */
	public String toString() {
		String toString = "";
		if (passing) {
			toString += PASS;
		} else {
			toString += FAIL;
		}
		toString = toString + ": " + actualResults; 
		return toString;
	}
	
	/**
	 * Returns fail
	 * @return Fail constant
	 */
	public static String getFail() {
		return FAIL;
	}

}
