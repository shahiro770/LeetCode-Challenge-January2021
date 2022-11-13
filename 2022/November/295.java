/*
 * Find Median from Data Stream
 *
 * Top 96% (111ms) 
 * 
 * We want a way to make accessing the middle values O(1). The easiest way to do this is with two heaps.
 *      1) The maxHeap will take the first value
 *      2) The minHeap will take any values larger than whats at the top of the maxHeap
 *      3) The maxHeap will take any values smaller than whats on top of it
 *      4) If either heap starts to exceed the other in size by more than 1 element, we rebalance them
 * 
 * Basically, by making sure the minHeap only has the larger half of the values, and the maxHeap only has
 * the smaller half of the values, the values at the top of the heaps wll be the middle values.
 * 
 * The best way to follow this dual heap system is to do an example:
 * Say we had the numbers 1,2,3,4,0 being added to the heap and we checked the median after each one.
 * 
 * 1) Insert 1:
 * MaxHeap: 1
 * MinHeap:
 * Median: Peek the maxheap (when size is odd) = 1
 * 
 * 2) Insert 2:
 * MaxHeap: 1
 * Min Heap: 2
 * Median: Peek of min heap + peek of max heap / 2 (when size is even) = 1.5
 * 
 * 3) Insert 3: 
 * MaxHeap: 1
 * MinHeap: 2,3
 * <After Rebalancing>
 * MaxHeap: 2,1
 * MinHeap: 3
 * Median: 2
 * 
 * 4) Insert 4:
 * MaxHeap: 1
 * MinHeap: 2,3,4
 * <After Rebalancing>
 * MaxHeap: 2,1
 * MinHeap: 3,4
 * Median: 2.5
 * 
 * 5) Insert 0:
 * MaxHeap: 1,0 
 * MinHeap: 2,3,4
 * <After Rebalancing>
 * MaxHeap: 2,1,0 
 * MinHeap: 3,4
 * Median: 2
 * 
 * Time Complexity: O(lgn) for insert, O(1) for getting the median
 */


class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    int size;

    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>((a,b) -> b - a);
        minHeap = new PriorityQueue<Integer>((a,b) -> a - b);
        size = 0;
    }

    public void addNum(int num) {
        size++;

        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        }
        else {
            minHeap.add(num);
        }

        // min heap and max heap will be kept to within 1 node of size apart,
        // with the max heap always being 1 more larger in size
        if (minHeap.size() + 1 < maxHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
        else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (size % 2 == 1) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

/*
    Heap Min: 1 2 3
    Heap Max: 3 2 1

*/

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */