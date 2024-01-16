/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

/**
 * The Log Class
 * Extends ILog interface
 * @param <E> the Type of the list
 */
public class Log<E> implements ILog<E> {
	/** The list of Objects */
	private E[] log;
	/** The size of the list */
	private int size;
	/** Constant that represents the initial capacity of the list */
	private static final int INIT_CAPACITY = 10;
	
	/**
	 * Creates the list of type E
	 * Suppresses unchecked warning
	 */
	@SuppressWarnings("unchecked")
	public Log() {
		log = (E[]) new Object[INIT_CAPACITY];
		size = 0;
	}
	
	@Override
	public void add(E element) {
		if (element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
		log[size] = element;
		size++;
	}

	@Override
	public E get(int idx) {
		if (idx >= size || idx < 0) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		return log[idx];
	}

	@Override
	public int size() {
		return size;
	}

}
