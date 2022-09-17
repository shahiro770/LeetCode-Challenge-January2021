/*
 * Numbers With Same Consecutive Differences
 * 
 * September 2022
 * Top 75% (3ms) 
 *
 * BFS with no need to keep track of visits
 *
 * Time complexity: O(2^n) since for every position, you get 2 possible outcomes, which leads to two more numbers to test
*/

class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        int[][] nums = new int[10][];
        ArrayList<Integer> sol = new ArrayList<Integer>();
        Queue<Integer> numDiscovery = new LinkedList<Integer>();
        double numLength = Math.pow(10, n - 1);
                        
        for (int i = 1; i <= 9; i++) {
            numDiscovery.add(i);
        }
        
        while(numDiscovery.size() > 0) {
            int num = numDiscovery.poll();
            if (num >= numLength) {
                sol.add(num);
            }
            else {
                
                int firstOption = (num % 10) - k;  
                int secondOption = (num % 10) + k;
                // since we're testing absolute difference, if the number goes below 0, we can't use it
                if (firstOption >= 0) { 
                    numDiscovery.add(num * 10 + firstOption);
                }
                // we're only checking for digits (can't exceed 9) and in the case k = 0, firstOption = secondOption so don't queue it twice
                if (secondOption < 10 && k != 0) {
                    numDiscovery.add(num * 10 + secondOption);
                }
            }
        }
        
        int[] arraySol = new int[sol.size()];
        int pos = 0;
        for (Integer i : sol) {
            arraySol[pos] = i;
            pos++;
        }
        
        return arraySol;
    }
}