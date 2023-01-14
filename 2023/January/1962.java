/*
 * Remove Stones to Minimize the Total
 * 
 * Top 98% (10ms)
 * 
 * Dumb solution surprisingly is a priority queue to put the value back in after "halving" it (yes its floored, whatever).
 * Naively, you can't sort the array since re-halving halved values could happen with k > 0 (i.e. [6,4,2], k = 3, 
 * will give us [2,2,2], 6 being halved to 3, 4 being halved to 2, and then 3 being halved to 2). 
 * 
 * Bucket sorting and starting from the end lets us precisely kick back the halved value at O(1) time, not relying 
 * on a logn heap property to find the next largest value.
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public int minStoneSum(int[] piles, int k) {
        int[] buckets = new int[10001];
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            buckets[piles[i]]++;
            sum += piles[i];
        }

        for (int i = buckets.length - 1; i > 0; i--) {
            int curr = buckets[i];
            int half = i / 2;
            int removable = Math.min(k, curr);
            
            k -= removable;
            buckets[(int) Math.ceil((float) i / 2)] += removable;
            sum -= removable * half;
            if (k == 0) {
                break;
            }
        }

        return sum;
    }
}