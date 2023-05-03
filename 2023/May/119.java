/*
 * Pascal's Triangle II
 *
 * Top 77% (1ms)
 * 
 * We taking it easy for the next while.
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public List<Integer> getRow(int numRows) {
        List<List<Integer>> sol = new ArrayList<List<Integer>>();
        List<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        sol.add(firstRow);

        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(sol.get(i - 1).get(j - 1) + sol.get(i - 1).get(j));
            }
            row.add(1);
            sol.add(row);
        }

        return sol.get(numRows);
    }
}