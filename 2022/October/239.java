/**
 * Sliding Window Maximum
 * 
 * Top 90% (34ms)
 * 
 * Learned about a monotonic decreasing queue (cool "data structure").
 * You add all the indices of the elements to the queue from the right, but remove
 * any elements that are less than the element to be added, maintaining its decreasing order.
 * Then, once you've added the i = k element, you can start building the max window by taking
 * the front of the queue (which will be the max).
 * 
 * Remove the front element once it gets out of range of the window (which you can do since 
 * the indices are being stored).
 * 
 * Time Complexity: O(n)
 * */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxWindow = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<Integer>();
        for (int i = 0; i < nums.length; i++) {
            while (dq.size() > 0 && nums[dq.peekLast()] < nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i); 
            if (dq.size() > k || (dq.peekFirst() + k - 1) < i ) {
                dq.removeFirst();
            }
            if (i >= (k - 1)) {
                maxWindow[i - (k - 1)] = nums[dq.peekFirst()];
            }
        }

        return maxWindow;
    }
}

/*
1,3,-1,-3,-1,5,3,6,7
2,2, 2, 1
*/