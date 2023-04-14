/*
 * Minimize Deviation in Array
 * Top 96% (107ms)
 * 
 * You can do this question by dividing down then multiplying up or multiplying up and then dividing down, 
 * I chose the latter.
 * 
 * Put everything in a treeset, multiplying all odd values by 2 so you only have even numbers to work with.
 * Keep track of your min and max seen and get your starting deviation. You only have even numbers to work with
 * here, so you can only divide down. Take the largest element from the tree set, divide and put it back in
 * the set, updating the max and min accordingly.
 * 
 * Note that a priorityQueue works too, but will be significantly slower due to duplicates. Duplicates
 * don't matter in this question so a treetset is faster.
 * 
 * Time Complexity: O (nlgn)
 */

 class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        TreeSet<Integer> set = new TreeSet<>();
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                set.add(nums[i] * 2);
                min = Math.min(min, nums[i] * 2);
            }
            else {
                set.add(nums[i]);
                min = Math.min(min, nums[i]);
            }
        }
        
        int max = set.last();
        int dev = max - min;
        while (true) {
            max = set.pollLast();   
            dev = Math.min(max - min, dev);
            if (max % 2 == 0) {     
                set.add(max / 2);    
                min = Math.min(max / 2, min);
            }
            else {
                break;
            }
        }
        
        return dev;
    }
}
