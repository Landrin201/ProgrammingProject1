package jsjf;

import jsjf.exceptions.*;

/**
 * LinkedOrderedList represents a singly linked implementation of an 
 * ordered list.
 *
 * @author Lewis and Chase
 * @version 4.0
 */
public class LinkedOrderedList<T> extends LinkedList<T> 
         implements OrderedListADT<T>
{
    /**
     * Creates an empty list.
     */
    public LinkedOrderedList()
    {
        super();
    }

    /**
     * Adds the specified element to this list at the location determined by
	 * the element's natural ordering. Throws a NonComparableElementException 
	 * if the element is not comparable.
     *
     * @param element the element to be added to this list
     * @throws NonComparableElementException if the element is not comparable
	 */
    public void add(T element)
    {
        // To be completed as a Programming Project
    }
}
