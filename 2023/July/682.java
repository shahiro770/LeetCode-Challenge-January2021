/*
 * Baseball Game
 * 
 * Top 85% (3ms)
 * 
 * Time Complexity: O(n);
 */

class Solution {
    public int calPoints(String[] operations) {
        ArrayList<Integer> scores = new ArrayList<Integer>();

        for (int i = 0; i < operations.length; i++) {
            int n = scores.size();
            if (operations[i].equals("+")) {
                
                scores.add(scores.get(n - 1) + scores.get(n - 2));
            }
            else if (operations[i].equals("D")) {
                scores.add(scores.get(n - 1) * 2);
            }
            else if (operations[i].equals("C")) {
                scores.remove(n - 1);
            }
            else {
                scores.add(Integer.parseInt(operations[i]));
            }   
        }

        // love me some streams
        return scores.stream().reduce(0, (a, b) -> a + b);
    }
}