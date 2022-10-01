/**
 * Find K Closest Elements
 * 
 * September 2022
 * Top 94% (4ms)  
 * 
 * Close the window around the numbers (prioritizing shrinking from the right first
 * due to the problem's definition of lower numbers being "closer" if the absolute
 * distance is the same).
 * 
 * Time complexity: O(n) 
 */


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
		int high = arr.length - 1;
		while (high - low >= k) {
			if (Math.abs(arr[low] - x) <= Math.abs(arr[high] - x)) {
				high--;
			} else {
				low++;
			}
		}
		List<Integer> sol = new ArrayList<Integer>();
		for (int i = low; i <= high; i++) {
			sol.add(arr[i]);
		}
		return sol;
    }
}