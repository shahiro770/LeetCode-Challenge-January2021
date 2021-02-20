
/**
 * Feb 2021 Day 8
 * 
 * Put this one in the weirdo questions pile. Top 94.26% but what did I gain?
 * Just store the value from next() and return it whenever needed (the actual next is 1 ahead, peek is where next() normally is)
 * 
 */

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class Solution implements Iterator<Integer> {
    private Iterator<Integer> myIt;
    private int peekedInt;
    private boolean hasPeek = false;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        myIt = iterator;	
        if (myIt.hasNext() == true) {
            peekedInt = myIt.next();
            hasPeek = true;
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peekedInt;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if (hasPeek == false) {
            return null;
        }
        int toReturn = peekedInt;
        if (myIt.hasNext() == true) {
            peekedInt = myIt.next();
            hasPeek = true;
        }
        else {
            hasPeek = false;
        }
        return toReturn;
	}
	
	@Override
	public boolean hasNext() {
        return hasPeek == true;
	}
}