package edu.ncsu.csc216.stp.model.manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.tests.TestCase;

class TestPlanManagerTest {

	@Test
	void testConstrcutor() {
		TestPlanManager t = new TestPlanManager();
		assertFalse(t.isChanged());
	}

	@Test
	void loadTestPlans() {
		fail();
	}
	
	@Test
	void saveTestPlans() {
		fail();
	}
	
	@Test
	void addTestPlan() {
		TestPlanManager t = new TestPlanManager();
		assertFalse(t.isChanged());
		t.addTestPlan("hi");
		assertEquals(t.getCurrentTestPlan().getTestPlanName(), "hi");
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> t.addTestPlan("hi"));
		assertEquals(e1.getMessage(), "Invalid name."); 	
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> t.addTestPlan("Failing Tests"));
		assertEquals(e2.getMessage(), "Invalid name."); 	
	}
	
	@Test
	void getTestPlanNames() {
		TestPlanManager t = new TestPlanManager();
		assertFalse(t.isChanged());
		t.addTestPlan("hi");
		assertEquals(t.getCurrentTestPlan().getTestPlanName(), "hi");
	}
	
	@Test
	void setCurrentTestPlan() {
		TestPlanManager t = new TestPlanManager();
		assertFalse(t.isChanged());
		t.addTestPlan("Barbarians");
		assertEquals(t.getCurrentTestPlan().getTestPlanName(), "Barbarians");
		t.addTestPlan("Archers");
		assertEquals(t.getCurrentTestPlan().getTestPlanName(), "Archers");
		t.setCurrentTestPlan("Barbarians");
		assertEquals(t.getCurrentTestPlan().getTestPlanName(), "Barbarians");
		t.setCurrentTestPlan("Goblins");
		assertEquals(t.getCurrentTestPlan().getTestPlanName(), "Failing Tests");
	}
	
	@Test
	void editTestPlan() {
		TestPlanManager t = new TestPlanManager();
		assertFalse(t.isChanged());
		t.addTestPlan("Barbarians");
		assertEquals(t.getCurrentTestPlan().getTestPlanName(), "Barbarians");
		t.addTestPlan("Archers");
		t.editTestPlan("Goblins");
		assertEquals(t.getCurrentTestPlan().getTestPlanName(), "Goblins");
		t.addTestPlan("Giants");
		t.addTestPlan("Balloons");
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> t.editTestPlan("Failing Tests"));
		assertEquals(e1.getMessage(), "Invalid name."); 	
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> t.editTestPlan("Barbarians"));
		assertEquals(e2.getMessage(), "Invalid name.");
		t.setCurrentTestPlan("Failing Tests");
		Exception e3 = assertThrows(IllegalArgumentException.class, () -> t.editTestPlan("Barbarians"));
		assertEquals(e3.getMessage(), "The Failing Tests list may not be edited.");
	}
	
	@Test
	void removeTestPlan() {
		TestPlanManager t = new TestPlanManager();
		assertFalse(t.isChanged());
		t.addTestPlan("Barbarians");
		assertEquals(t.getCurrentTestPlan().getTestPlanName(), "Barbarians");
		t.addTestPlan("Archers");
		assertEquals(t.getCurrentTestPlan().getTestPlanName(), "Archers");
		t.addTestPlan("Goblins");
		assertEquals(t.getCurrentTestPlan().getTestPlanName(), "Goblins");
		t.addTestPlan("Giants");
		t.addTestPlan("Wallbreakers");
		t.addTestPlan("Balloons");
		t.addTestPlan("Wizards");
		t.addTestPlan("Healers");
		t.removeTestPlan();
		assertEquals("Failing Tests", t.getCurrentTestPlan().getTestPlanName());
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> t.removeTestPlan());
		assertEquals(e1.getMessage(), "The Failing Tests list may not be deleted."); 	
	}
	
	@Test
	void addTestCase() {
		TestPlanManager t = new TestPlanManager();
		assertFalse(t.isChanged());
		t.addTestPlan("Barbarians");
		assertEquals(t.getCurrentTestPlan().getTestPlanName(), "Barbarians");
		t.addTestPlan("Archers");
		assertEquals(t.getCurrentTestPlan().getTestPlanName(), "Archers");
		t.addTestPlan("Goblins");
		assertEquals(t.getCurrentTestPlan().getTestPlanName(), "Goblins");
		t.addTestPlan("Giants");
		t.addTestPlan("Wallbreakers");
		t.addTestPlan("Balloons");
		t.addTestPlan("Wizards");
		t.addTestPlan("Healers");
		TestCase y = new TestCase("Battle healer", "Troop", "heal people", "4 elixir");
		t.addTestCase(y);
		assertTrue(t.isChanged());
		assertEquals(t.getCurrentTestPlan().getTestCase(0).getTestCaseId(), "Battle healer");
		assertEquals(t.getCurrentTestPlan().getTestCase(0).getTestType(), "Troop");
		assertEquals(t.getCurrentTestPlan().getTestCase(0).getTestDescription(), "heal people");
		assertEquals(t.getCurrentTestPlan().getTestCase(0).getExpectedResults(), "4 elixir");
		t.addTestPlan("Dragons");
		TestCase d = new TestCase("Super Dragon", "Troop", "do a lot of damage", "432");
		TestCase d2 = new TestCase("Electro Dragon", "Troop", "Be no skill", "1 star");
		d2.addTestResult(false, "2 stars");
		t.addTestCase(d);
		t.addTestCase(d2);
		t.setCurrentTestPlan("Failing Tests");
		assertEquals("Super Dragon", t.getCurrentTestPlan().getTestCase(0).getTestCaseId());
	}
	
	@Test
	void addTestResult() {
		TestPlanManager t = new TestPlanManager();
		assertFalse(t.isChanged());
		t.addTestPlan("Barbarians");
		assertEquals(t.getCurrentTestPlan().getTestPlanName(), "Barbarians");
		t.addTestPlan("Archers");
		assertEquals(t.getCurrentTestPlan().getTestPlanName(), "Archers");
		t.addTestPlan("Goblins");
		assertEquals(t.getCurrentTestPlan().getTestPlanName(), "Goblins");
		t.addTestPlan("Giants");
		t.addTestPlan("Wallbreakers");
		t.addTestPlan("Balloons");
		t.addTestPlan("Wizards");
		t.addTestPlan("Healers");
		TestCase y = new TestCase("Battle healer", "Troop", "heal people", "4 elixir");
		t.addTestCase(y);
		assertTrue(t.isChanged());
		assertEquals(t.getCurrentTestPlan().getTestCase(0).getTestCaseId(), "Battle healer");
		assertEquals(t.getCurrentTestPlan().getTestCase(0).getTestType(), "Troop");
		assertEquals(t.getCurrentTestPlan().getTestCase(0).getTestDescription(), "heal people");
		assertEquals(t.getCurrentTestPlan().getTestCase(0).getExpectedResults(), "4 elixir");
		t.addTestPlan("Dragons");
		TestCase d = new TestCase("Super Dragon", "Troop", "do a lot of damage", "432");
		TestCase d2 = new TestCase("Electro Dragon", "Troop", "Be no skill", "1 star");
		t.addTestCase(d);
		t.addTestCase(d2);
		t.addTestResult(0, true, "Dragon Cliffs :))))))))))))))))))))))");
		t.addTestResult(1, false, "2 stars");
		assertEquals(t.getCurrentTestPlan().getTestCase(0).getStatus(), "PASS");
		assertEquals(t.getCurrentTestPlan().getTestCase(1).getStatus(), "FAIL");
		t.setCurrentTestPlan("Failing Tests");
		assertEquals(t.getCurrentTestPlan().getTestCase(0).getTestCaseId(), "Electro Dragon");
	}
	
	@Test
	void clearTestPlans() {
		TestPlanManager t = new TestPlanManager();
		assertFalse(t.isChanged());
		t.addTestPlan("Barbarians");
		assertEquals(t.getCurrentTestPlan().getTestPlanName(), "Barbarians");
		t.addTestPlan("Archers");
		assertEquals(t.getCurrentTestPlan().getTestPlanName(), "Archers");
		t.addTestPlan("Goblins");
		assertEquals(t.getCurrentTestPlan().getTestPlanName(), "Goblins");
		t.addTestPlan("Giants");
		t.addTestPlan("Wallbreakers");
		t.addTestPlan("Balloons");
		t.addTestPlan("Wizards");
		t.addTestPlan("Healers");
		TestCase y = new TestCase("Battle healer", "Troop", "heal people", "4 elixir");
		t.addTestCase(y);
		assertTrue(t.isChanged());
		assertEquals(t.getCurrentTestPlan().getTestCase(0).getTestCaseId(), "Battle healer");
		assertEquals(t.getCurrentTestPlan().getTestCase(0).getTestType(), "Troop");
		assertEquals(t.getCurrentTestPlan().getTestCase(0).getTestDescription(), "heal people");
		assertEquals(t.getCurrentTestPlan().getTestCase(0).getExpectedResults(), "4 elixir");
		t.addTestPlan("Dragons");
		TestCase d = new TestCase("Super Dragon", "Troop", "do a lot of damage", "432");
		TestCase d2 = new TestCase("Electro Dragon", "Troop", "Be no skill", "1 star");
		t.addTestCase(d);
		t.addTestCase(d2);
		t.addTestResult(0, true, "Dragon Cliffs :))))))))))))))))))))))");
		t.addTestResult(1, false, "2 stars");
		assertEquals(t.getCurrentTestPlan().getTestCase(0).getStatus(), "PASS");
		assertEquals(t.getCurrentTestPlan().getTestCase(1).getStatus(), "FAIL");
		t.setCurrentTestPlan("Failing Tests");
		assertEquals(t.getCurrentTestPlan().getTestCase(0).getTestCaseId(), "Electro Dragon");
		t.clearTestPlans();
		assertEquals(t.getCurrentTestPlan().getTestPlanName(), "Failing Tests");
		assertEquals(t.getCurrentTestPlan().getNumberOfFailingTests(), 0);
		assertFalse(t.isChanged());
		
	}
}
