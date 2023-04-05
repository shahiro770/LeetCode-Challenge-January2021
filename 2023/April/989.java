/*
 * Add to Array-Form of Integer
 * 
 * Top 74% (4ms)
 * 
 * LinkedList > ArrayList for efficiency (adding to the front of an arraylist
 * causes the internal array to shift everything down, slow)
 * 
 * Time complexity: O(n)
 */

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> sol = new LinkedList<>();

        for (int i = num.length - 1; i >= 0; i--) {
            /*
             * num[i] + k % 10 gets us the right most digit
             */
            sol.add(0, (num[i] + k) % 10);
            /*
             * Discard the right most digit of k as we move to the left of num
             * Notice that we take num[i] + k to preserve the "carry" inside k
             */
            k = (num[i] + k) / 10;
        }


        while (k > 0) {
            sol.add(0, k % 10);
            k /= 10;
        }

        return sol;
    }
}