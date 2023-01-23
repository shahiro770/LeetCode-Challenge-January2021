/*
 * Gas Station
 * 
 * 
 * 
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