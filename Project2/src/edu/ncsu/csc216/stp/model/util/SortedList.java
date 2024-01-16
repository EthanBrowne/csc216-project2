
package edu.ncsu.csc216.stp.model.util;

/** 
 * The sorted List Class has a list of items in a sorted order
  * This class provides methods for adding, removing, and querying elements
 * in a sorted manner.
 *
 * @param <E> the Type of the list
  * 
  */
public class SortedList<E extends Comparable<E>> implements ISortedList<E> {
	/** The size of the list */
	private int size;
	/** The listNode of the front of the list */
	private ListNode front;
	
	/**
	 * The sorted list constructor
	 */
	public SortedList() {
		front = null;
	}
	
	@Override
	public void add(E element) {
		if (element == null) {
			throw new NullPointerException("Cannot add null element.");
		} else if (front == null || element.compareTo(front.data) < 0) {
			front = new ListNode(element, front);
		} else if (contains(element)) {
			throw new IllegalArgumentException("Cannot add duplicate element.");
		} else {
			ListNode current = front;
			while (current.next != null && current.next.data.compareTo(element) <  0) {
				current = current.next;
			}
			current.next = new ListNode(element, current.next);
		}
		size++;
	}

	@Override
	public E remove(int idx) {
		if (idx > size - 1 || idx < 0) {
			throw new IndexOutOfBoundsException("Invalid index.");
		} else if (idx == 0) {
			E r = front.data;
			front = front.next;
			size--;
			return r;
		}
		ListNode current = front;
		for (int i = 0; i < idx - 1; i++) {
			current = current.next;
		}
		E value = current.next.data;
		current.next = current.next.next;
		size--;
		return value;
	}

	@Override
	public boolean contains(E element) {
		if (front.data == element) {
			return true;
		}
		ListNode current = front;
		for (int i = 0; i < size - 1; i++) {
			current = current.next;
			if (current.data == element) {
				return true;
			}
		}
		return false;
	}

	@Override
	public E get(int idx) {
		if (idx > size - 1 || idx < 0) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		ListNode current = front;
		for (int i = 0; i < idx; i++) {
			current = current.next;
		}
		return current.data;
	}

	@Override
	public int size() {
		return size;
	}
	
	/**
	 * ListNode Class
	 */
	public class ListNode {
		/** The data in the listnode */
		public E data;
		/** The next listnode in the array */
		private ListNode next;
		
		/**
		 * The ListNode Constructor
		 * @param data the data in the listnode
		 * @param next the next listnode
		 */
		public ListNode (E data, ListNode next){
			this.data = data;
			this.next = next;
		}
	}
	

}
