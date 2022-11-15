/*
 * Median of Two Sorted Arrays
 * 
 * Top 82% (4ms)
 * 
 * You need to see this https://www.youtube.com/embed/q6IEA26hvXc
 * 
 * The overall intuition for this question makes sense with enough time:
 * 1) Viewing the lower half of the combined array as subarrays of nums1 and nums2
 * 2) The logic to figure out if you found the correct partition is by making sure no value that
 * comes right after the end of either subarray exceeds the largest value in either subarray
 * 
 * The difficulty of this algorithm and question comes from the indexing. There's so many edge
 * cases that dealing with them "elegantly" is still a pain:
 * 1) Which array do you binary search on?
 * 2) What if no value is needed from one array because the median is determined to not be there?
 * 3) How do you deal with going out of bounds for the array with your boundary checks?
 * 
 * This question is so unforgiving to debug since a bug means runtime error or stack overflow
 * with no inbetween.
 * 
 * Time Complexity: O(lg(m + n))
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalSize = nums1.length + nums2.length;
        int half = (totalSize) / 2;

        int[] a;
        int[] b;
        // for convenience, make it so the first array is always the larger one
        if (nums1.length > nums2.length) {
            a = nums2;
            b = nums1;
        }
        else {
            a = nums1;
            b = nums2;
        }
        // System.out.println("Half: " + half + " totalSize: " + totalSize);
        // System.out.print("A: ");
        // for (int x : a) {
        //     System.out.print(x + " ");
        // }
        // System.out.println("");
        // System.out.print("B: ");
        // for (int x : b) {
        //     System.out.print(x + " ");
        // }
        // System.out.println("\n");

        int l = 0;
        int r = a.length - 1;
        // System.out.println("Starting: " + l + " " + r);
        while (true) {
            int midA = (l + r) / 2;
            // if the left passes the right, that implies we don't need to use
            // ANY value in the smaller array; setting the midpoint to -1 will
            // force us to take all elements from the larger
            if (l > r) {    
                midA = -1;
            }
            int midB = half - midA - 2;
            /*
             * This logic is done to make handling edgecases easier,
             * mainly if we go past the boundaries of either array, we can jsut treat them
             * as taking extremely large or small numbers depending on the case 
             */
            int aLeft = midA >= 0 ? a[midA] : Integer.MIN_VALUE;
            int aRight = midA + 1 < a.length ? a[midA + 1] : Integer.MAX_VALUE;
            
            int bLeft = midB >= 0 ? b[midB] : Integer.MIN_VALUE;
            int bRight = midB + 1 < b.length ? b[midB + 1] : Integer.MAX_VALUE;
            // System.out.println("A: " + aLeft + " " + aRight + " midA: " + midA);
            // System.out.println("B: " + bLeft + " " + bRight + " midB: " + midB);
            if (aLeft <= bRight && bLeft <= aRight) {
                if (totalSize % 2 == 0) {
                    return ((double)Math.max(aLeft, bLeft) + (double)Math.min(aRight, bRight)) / 2;
                }
                else {
                    return Math.min(aRight, bRight);
                }
            }
            else {
                if (aLeft > bRight) {
                    r = midA - 1;
                    // System.out.println("Shrinking right " + l + " " + r);
                }
                else {
                    l = midA + 1;
                    // System.out.println("Shrinking left " + l + " " + r);
                }
            }
        }
    }
}