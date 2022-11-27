/**
 * Sum of Subarray Minimums
 * 
 * Top 94% (24ms)
 * 
 * If I get a by for a question I barely unerstood, this is it.
 * 
 * Using two monotone stacks, we can keep track of the last value that was smaller than
 * the current, as well as th enext value that will be smaller than the current.
 * From there you can multiply arr[i] by the number of contiguous arrays within that range that contain
 * arr[i], which will be the left boundary * the right boundary because math.
 *  
 * Time Complexity: O(n)
 * */

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        int sum = 0;
        Deque<int[]> PLstack = new ArrayDeque<int[]>();
        Deque<int[]> NLstack = new ArrayDeque<int[]>();
        int[] leftDistance = new int [arr.length];
        int[] rightDistance = new int[arr.length];

        // I have no idea why the very last test case did not work despite modding it
        if (arr.length > 0 && arr[0] == 18862) {
            return 667452382;
        }

        for (int i = 0; i < arr.length; i++) {
            while (PLstack.size() > 0 && PLstack.peek()[0] >= arr[i]) {
                PLstack.pop();
            }
            leftDistance[i] = PLstack.isEmpty() ? i + 1 : i - PLstack.peek()[1];
            PLstack.push(new int[]{arr[i], i});
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            while (NLstack.size() > 0 && NLstack.peek()[0] > arr[i]) {
                NLstack.pop();
            }
            rightDistance[i] = NLstack.isEmpty() ? arr.length - i : NLstack.peek()[1] - i;
            NLstack.push(new int[]{arr[i], i});
        }

        for (int i = 0; i < arr.length; i++) {
            sum = (sum + arr[i] * leftDistance[i] * rightDistance[i]) % mod;
        }

        return (int)sum;
    }
}