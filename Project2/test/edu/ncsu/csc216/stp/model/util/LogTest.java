package edu.ncsu.csc216.stp.model.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LogTest {

	@Test
	void test() {
		Log<String> newlog = new Log<String>();
		assertEquals(newlog.size(), 0);
	}
	
	@Test
	void testAdd() {
		Log<String> newlog = new Log<String>();
		assertEquals(newlog.size(), 0);
		newlog.add("Hi");
		assertEquals(newlog.size(), 1);
		newlog.add("Hi Ethan");
		assertEquals(newlog.size(), 2);
		newlog.add("ok bye");
		assertEquals(newlog.size(), 3);
		newlog.add("Mortis");
		assertEquals(newlog.size(), 4);
		newlog.add("Shelly");
		assertEquals(newlog.size(), 5);
	}
	
	@Test
	void testGet() {
		Log<String> newlog = new Log<String>();
		assertEquals(newlog.size(), 0);
		newlog.add("Hi");
		assertEquals(newlog.size(), 1);
		newlog.add("Hi Ethan");
		assertEquals(newlog.size(), 2);
		newlog.add("ok bye");
		assertEquals(newlog.size(), 3);
		newlog.add("Mortis");
		assertEquals(newlog.size(), 4);
		newlog.add("Shelly");
		assertEquals(newlog.size(), 5);
		assertEquals(newlog.get(0), "Hi");
		assertEquals(newlog.get(1), "Hi Ethan");
		assertEquals(newlog.get(2), "ok bye");
		assertEquals(newlog.get(3), "Mortis");
		assertEquals(newlog.get(4), "Shelly");
		
		Exception e1 = assertThrows(IndexOutOfBoundsException.class,
				() -> newlog.get(-1));
		assertEquals(e1.getMessage(), "Invalid index.");
		
		Exception e2 = assertThrows(IndexOutOfBoundsException.class,
				() -> newlog.get(10192381));
		assertEquals(e2.getMessage(), "Invalid index.");
	}
	
	@Test
	void testAddInvalid() {
		Log<String> newlog = new Log<String>();
		Exception e1 = assertThrows(NullPointerException.class,
				() -> newlog.add(null));
		assertEquals(e1.getMessage(), "Cannot add null element.");
		assertEquals(newlog.size(), 0);
		newlog.add("Hi");
		assertEquals(newlog.size(), 1);
		newlog.add("Hi Ethan");
		assertEquals(newlog.size(), 2);
		newlog.add("ok bye");
		assertEquals(newlog.size(), 3);
		newlog.add("Mortis");
		assertEquals(newlog.size(), 4);
		newlog.add("Shelly");
		assertEquals(newlog.size(), 5);
	}
}
