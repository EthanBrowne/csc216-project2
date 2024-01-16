/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */
class SwapListTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.SwapList#SwapList()}.
	 */
	@Test
	void testSwapList() {
		SwapList<String> s = new SwapList<String>();
		assertEquals(s.size(), 0);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.SwapList#add(java.lang.Object)}.
	 */
	@Test
	void testAdd() {
		SwapList<String> a = new SwapList<String>();
		a.add("Shelly");
		assertEquals(a.get(0), "Shelly");
		assertEquals(a.size(), 1);
		a.add("Nita");
		assertEquals(a.get(1), "Nita");
		assertEquals(a.size(), 2);
		a.add("Colt");
		assertEquals(a.get(2), "Colt");
		assertEquals(a.size(), 3);
		a.add("Bull");
		assertEquals(a.get(3), "Bull");
		assertEquals(a.size(), 4);
		Exception e = assertThrows(NullPointerException.class, () -> a.add(null));
		assertEquals(e.getMessage(), "Cannot add null element.");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.SwapList#remove(int)}.
	 */
	@Test
	void testRemove() {
		SwapList<String> a = new SwapList<String>();
		a.add("Smelly");
		assertEquals(a.get(0), "Smelly");
		assertEquals(a.size(), 1);
		a.add("Nito");
		assertEquals(a.get(1), "Nito");
		assertEquals(a.size(), 2);
		a.add("Cold");
		assertEquals(a.get(2), "Cold");
		assertEquals(a.size(), 3);
		a.add("Bell");
		assertEquals(a.get(3), "Bell");
		assertEquals(a.size(), 4);
		Exception e = assertThrows(NullPointerException.class, () -> a.add(null));
		assertEquals(e.getMessage(), "Cannot add null element.");
		Exception e3 = assertThrows(IndexOutOfBoundsException.class, () -> a.remove(100));
		assertEquals(e3.getMessage(), "Invalid index.");
		Exception e4 = assertThrows(IndexOutOfBoundsException.class, () -> a.remove(-1));
		assertEquals(e4.getMessage(), "Invalid index.");
		
		assertEquals(a.remove(3), "Bell");
		assertEquals(a.size(), 3);
		assertEquals(a.remove(2), "Cold");
		assertEquals(a.size(), 2);
		assertEquals(a.remove(1), "Nito");
		assertEquals(a.size(), 1);
		assertEquals(a.remove(0), "Smelly");
		assertEquals(a.size(), 0);
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.SwapList#moveUp(int)}.
	 */
	@Test
	void testMoveUp() {
		SwapList<String> a = new SwapList<String>();
		a.add("Smelly");
		assertEquals(a.get(0), "Smelly");
		assertEquals(a.size(), 1);
		a.add("Nito");
		assertEquals(a.get(1), "Nito");
		assertEquals(a.size(), 2);
		a.add("Cold");
		assertEquals(a.get(2), "Cold");
		assertEquals(a.size(), 3);
		a.add("Bell");
		assertEquals(a.get(3), "Bell");
		assertEquals(a.size(), 4);
		a.moveUp(0);
		assertEquals(a.get(0), "Smelly");
		a.moveUp(2);
		assertEquals(a.get(1), "Cold");
		assertEquals(a.get(2), "Nito");
		a.moveUp(3);
		assertEquals("Bell", a.get(2));
		assertEquals(a.get(3), "Nito");
		Exception e3 = assertThrows(IndexOutOfBoundsException.class, () -> a.remove(100));
		assertEquals(e3.getMessage(), "Invalid index.");
		Exception e4 = assertThrows(IndexOutOfBoundsException.class, () -> a.remove(-1));
		assertEquals(e4.getMessage(), "Invalid index.");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.SwapList#moveDown(int)}.
	 */
	@Test
	void testMoveDown() {
		SwapList<String> a = new SwapList<String>();
		a.add("Smelly");
		assertEquals(a.get(0), "Smelly");
		assertEquals(a.size(), 1);
		a.add("Nito");
		assertEquals(a.get(1), "Nito");
		assertEquals(a.size(), 2);
		a.add("Cold");
		assertEquals(a.get(2), "Cold");
		assertEquals(a.size(), 3);
		a.add("Bell");
		assertEquals(a.get(3), "Bell");
		assertEquals(a.size(), 4);
		a.moveDown(0);
		assertEquals(a.get(0), "Nito");
		assertEquals(a.get(1), "Smelly");
		a.moveDown(2);
		assertEquals(a.get(2), "Bell");
		assertEquals(a.get(3), "Cold");
		a.moveDown(3);
		assertEquals(a.get(3), "Cold");
		Exception e3 = assertThrows(IndexOutOfBoundsException.class, () -> a.remove(100));
		assertEquals(e3.getMessage(), "Invalid index.");
		Exception e4 = assertThrows(IndexOutOfBoundsException.class, () -> a.remove(-1));
		assertEquals(e4.getMessage(), "Invalid index.");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.SwapList#moveToFront(int)}.
	 */
	@Test
	void testMoveToFront() {
		SwapList<String> a = new SwapList<String>();
		a.add("Smelly");
		assertEquals(a.get(0), "Smelly");
		assertEquals(a.size(), 1);
		a.add("Nito");
		assertEquals(a.get(1), "Nito");
		assertEquals(a.size(), 2);
		a.add("Cold");
		assertEquals(a.get(2), "Cold");
		assertEquals(a.size(), 3);
		a.add("Bell");
		assertEquals(a.get(3), "Bell");
		assertEquals(a.size(), 4);
		a.add("Mortis");
		assertEquals(a.get(4), "Mortis");
		assertEquals(a.size(), 5);
		a.moveToFront(2);
		assertEquals(a.get(0), "Cold");
		a.moveToFront(0);
		assertEquals(a.get(0), "Cold");
		a.moveToFront(4);
		assertEquals(a.get(0), "Mortis");
		Exception e3 = assertThrows(IndexOutOfBoundsException.class, () -> a.remove(100));
		assertEquals(e3.getMessage(), "Invalid index.");
		Exception e4 = assertThrows(IndexOutOfBoundsException.class, () -> a.remove(-1));
		assertEquals(e4.getMessage(), "Invalid index.");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.SwapList#moveToBack(int)}.
	 */
	@Test
	void testMoveToBack() {
		SwapList<String> a = new SwapList<String>();
		a.add("Smelly");
		assertEquals(a.get(0), "Smelly");
		assertEquals(a.size(), 1);
		a.add("Nito");
		assertEquals(a.get(1), "Nito");
		assertEquals(a.size(), 2);
		a.add("Cold");
		assertEquals(a.get(2), "Cold");
		assertEquals(a.size(), 3);
		a.add("Bell");
		assertEquals(a.get(3), "Bell");
		assertEquals(a.size(), 4);
		a.add("Mortis");
		assertEquals(a.get(4), "Mortis");
		assertEquals(a.size(), 5);
		a.moveToBack(2);
		assertEquals(a.get(4), "Cold");
		a.moveToBack(0);
		assertEquals(a.get(4), "Smelly");
		a.moveToBack(4);
		assertEquals(a.get(4), "Smelly");
		Exception e3 = assertThrows(IndexOutOfBoundsException.class, () -> a.remove(100));
		assertEquals(e3.getMessage(), "Invalid index.");
		Exception e4 = assertThrows(IndexOutOfBoundsException.class, () -> a.remove(-1));
		assertEquals(e4.getMessage(), "Invalid index.");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.SwapList#get(int)}.
	 */
	@Test
	void testGet() {
		SwapList<String> a = new SwapList<String>();
		a.add("Smelly");
		assertEquals(a.get(0), "Smelly");
		assertEquals(a.size(), 1);
		a.add("Nito");
		assertEquals(a.get(1), "Nito");
		assertEquals(a.size(), 2);
		a.add("Cold");
		assertEquals(a.get(2), "Cold");
		assertEquals(a.size(), 3);
		a.add("Bell");
		assertEquals(a.get(3), "Bell");
		assertEquals(a.size(), 4);
		a.add("Mortis");
		assertEquals(a.get(4), "Mortis");
		assertEquals(a.size(), 5);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.SwapList#size()}.
	 */
	@Test
	void testSize() {
		SwapList<String> a = new SwapList<String>();
		a.add("Smelly");
		assertEquals(a.get(0), "Smelly");
		assertEquals(a.size(), 1);
		a.add("Nito");
		assertEquals(a.get(1), "Nito");
		assertEquals(a.size(), 2);
		a.add("Cold");
		assertEquals(a.get(2), "Cold");
		assertEquals(a.size(), 3);
		a.add("Bell");
		assertEquals(a.get(3), "Bell");
		assertEquals(a.size(), 4);
		a.add("Mortis");
		assertEquals(a.get(4), "Mortis");
		assertEquals(a.size(), 5);
	}

}
