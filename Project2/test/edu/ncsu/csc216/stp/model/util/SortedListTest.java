/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */
class SortedListTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.SortedList#SortedList()}.
	 */
	@Test
	void testSortedList() {
		SortedList<String> s = new SortedList<>();
		assertEquals(0, s.size());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.SortedList#add(java.lang.Comparable)}.
	 */
	@Test
	void testAdd() {
		SortedList<String> s = new SortedList<>();
		s.add("Ethan");
		s.add("Andy");
		s.add("Cyril");
		s.add("David");
		assertEquals(4, s.size());
		assertEquals("Ethan", s.get(3));
		assertEquals("David", s.get(2));
		assertEquals("Cyril", s.get(1));
		assertEquals("Andy", s.get(0));
		
		Exception e1 = assertThrows(NullPointerException.class,
				() -> s.add(null));
		assertEquals(e1.getMessage(), "Cannot add null element.");
		
		Exception e2 = assertThrows(IllegalArgumentException.class,
				() -> s.add("Cyril"));
		assertEquals(e2.getMessage(), "Cannot add duplicate element.");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.SortedList#remove(int)}.
	 */
	@Test
	void testRemove() {
		SortedList<String> s = new SortedList<>();
		s.add("Ethan");
		s.add("Andy");
		s.add("Cyril");
		s.add("David");
		assertEquals(4, s.size());
		assertEquals("Ethan", s.get(3));
		assertEquals("David", s.get(2));
		assertEquals("Cyril", s.get(1));
		assertEquals("Andy", s.get(0));
		s.remove(1);
		
		assertEquals(3, s.size());
		assertEquals("Ethan", s.get(2));
		assertEquals("David", s.get(1));
		assertEquals("Andy", s.get(0));
		s.remove(0);
		
		assertEquals(2, s.size());
		assertEquals("Ethan", s.get(1));
		assertEquals("David", s.get(0));
		s.remove(1);
		
		assertEquals(1, s.size());
		assertEquals("David", s.get(0));
		s.remove(0);
		
		assertEquals(0, s.size());
		
		Exception e1 = assertThrows(IndexOutOfBoundsException.class,
				() -> s.get(-1));
		assertEquals(e1.getMessage(), "Invalid index.");
		
		Exception e2 = assertThrows(IndexOutOfBoundsException.class,
				() -> s.get(100));
		assertEquals(e2.getMessage(), "Invalid index.");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.SortedList#contains(java.lang.Comparable)}.
	 */
	@Test
	void testContains() {
		SortedList<String> s = new SortedList<>();
		s.add("Ethan");
		s.add("Andy");
		s.add("Cyril");
		s.add("David");
		assertEquals(4, s.size());
		assertTrue(s.contains("Ethan"));
		assertTrue(s.contains("Cyril"));
		assertTrue(s.contains("David"));
		assertTrue(s.contains("Andy"));
		assertFalse(s.contains("Nobody"));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.SortedList#get(int)}.
	 */
	@Test
	void testGet() {
		SortedList<String> s = new SortedList<>();
		s.add("Ethan");
		s.add("Andy");
		s.add("Cyril");
		s.add("David");
		assertEquals("Ethan", s.get(3));
		assertEquals("David", s.get(2));
		assertEquals("Cyril", s.get(1));
		assertEquals("Andy", s.get(0));
		
		Exception e1 = assertThrows(IndexOutOfBoundsException.class,
				() -> s.get(-1));
		assertEquals(e1.getMessage(), "Invalid index.");
		
		Exception e2 = assertThrows(IndexOutOfBoundsException.class,
				() -> s.get(100));
		assertEquals(e2.getMessage(), "Invalid index.");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.SortedList#size()}.
	 */
	@Test
	void testSize() {
		SortedList<String> s = new SortedList<>();
		assertEquals(0, s.size());
		s.add("Ethan");
		assertEquals(1, s.size());
		s.add("Andy");
		assertEquals(2, s.size());
		s.add("Cyril");
		assertEquals(3, s.size());
		s.add("David");
		assertEquals(4, s.size());
	}

}
