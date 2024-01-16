/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

/**
 * The SwapList Class
 * Extends ISwapList interface
 * @param <E> the Type of the list
 */
public class SwapList<E> implements ISwapList<E> {
	/** The list of Objects */
	private E[] list;
	/** The size of the list */
	private int size;
	/** Constant that represents the initial capacity of the list */
	private static final int INIT_CAPACITY = 10;
	
	/**
	 * Creates the list of type E
	 * Suppresses unchecked warning
	 */
	@SuppressWarnings("unchecked")
	public SwapList() {
		list = (E[]) new Object[INIT_CAPACITY];
	}
	
	@Override
	public void add(E element) {
		if (element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
		if(size >= list.length) {
			checkCapacity();
		}
		list[size] = element;
		size++;
	}

	@Override
	public E remove(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		E removed = list[idx];
		for (int i = idx; i < size - 1; i++ ) {
			list[i] = list[i + 1];
		}
		list[size] = null;
		size--;
		return removed;
	}

	@Override
	public void moveUp(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		if(idx == 0) {
			return;
		}
		E temp = list[idx - 1];
		list[idx - 1] = list[idx];
		list[idx] = temp;
	}

	@Override
	public void moveDown(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		if (idx + 1 == size) {
			return;
		}
		E temp = list[idx + 1];
		list[idx + 1] = list[idx];
		list[idx] = temp;
	}

	@Override
	public void moveToFront(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		E temp = list[idx];
		for (int i = idx; i > 1; i--) {
			list[i] = list[i - 1];
		}
		list[0] = temp;
	}

	@Override
	public void moveToBack(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		E temp = list[idx];
		for (int i = idx; i < size - 2; i++) {
			list[i] = list[i + 1];
		}
		list[size - 1] = temp;
	}

	@Override
	public E get(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		return list[idx];
	}

	@Override
	public int size() {
		return size;
	}
	
	private void checkCapacity() {
		E[] list2 = (E[]) new Object[size * 2];
		 for (int i = 0; i < size; i++) {
			 list2[i] = list[i];
		 }
		list = list2;
	}
	
}
