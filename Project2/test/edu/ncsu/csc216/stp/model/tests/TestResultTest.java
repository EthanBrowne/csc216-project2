package edu.ncsu.csc216.stp.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestResultTest {

	@Test
	void testTestResult() {
		assertThrows(IllegalArgumentException.class, () -> new TestResult(true, null));
		TestResult t = new TestResult(true, "I did my Brawl Stars dailies");
		assertEquals(t.toString(), "PASS: I did my Brawl Stars dailies");
		assertTrue(t.isPassing());
		assertEquals(t.getActualResults(), "I did my Brawl Stars dailies");
	}

}
