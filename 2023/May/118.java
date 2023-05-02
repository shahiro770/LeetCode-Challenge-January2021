/*
 * Pascal's Triangle
 *
 * Top 92% (1ms)
 * 
 * Time Complexity:O(n(n + 1)/2) where n is numRows
 * 
 */

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> sol = new ArrayList<List<Integer>>();
        List<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        sol.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(sol.get(i - 1).get(j - 1) + sol.get(i - 1).get(j));
            }
            row.add(1);
            sol.add(row);
        }

        return sol;
    }
}