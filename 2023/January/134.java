/*
 * Gas Station
 * 
 * This question is kind of a weird logic problem due to the "guaranteed unique solution" constraint.
 * 1) If you sum all the gas differentials, if the total sum >= 0, it is possible to run the circuit
 * 2) Iterating from right to left, the spot where you have the largest summed gas differential is the starting spot
 *      Since you always move right, the largest amount of gas to move from right -> left will be the best starting spot
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int largest = -1;
        int largestGas = Integer.MIN_VALUE;

        for (int i = gas.length - 1; i >= 0; i--) {
            totalGas += gas[i] - cost[i];
            if (largestGas < totalGas) {
                largestGas = totalGas;
                largest = i;
            }
        }

        return totalGas >= 0 ? largest : -1;
    }
}