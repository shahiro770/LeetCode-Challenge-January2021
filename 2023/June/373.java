/*
 * Find K Pairs with Smallest Sums
 * 
 * Top 86% (34 ms)
 * 
 * Pair every number in nums2 with the first number in nums1 (as this will be its cheapest partner).
 * From there throw them all in a priority queue, moving the number in nums1 up for each pair when
 * its polled.
 * 
 * Time Complexity: O(klogk)
 */

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        ArrayList<List<Integer>> pairs = new ArrayList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a, b) -> {
            return (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]);
        });

        /*
         * If we need k pairs, those k pairs will exist among the first k elements
         * in nums1, nums2 (this saves like 10ms in performance)
         */
        for (int i = 0; i < nums2.length && i < k; i++) {   
            heap.add(new int[] {0, i});
        }

        while (pairs.size() < k && heap.size() > 0) {
            int[] pair = heap.poll();
            ArrayList<Integer> pairList = new ArrayList<>();
            pairList.add(nums1[pair[0]]);
            pairList.add(nums2[pair[1]]);            
            pairs.add(pairList);

            if (pair[0] + 1 < nums1.length) {
                pair[0]++;
                heap.offer(pair);
            }
        }

        return pairs;
    }
}