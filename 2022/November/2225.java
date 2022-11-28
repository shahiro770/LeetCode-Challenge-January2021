/**
 * Find Players With Zero or One Losses
 * 
 * Top 96% (80ms)
 * 
 * Just keep a count in a map of the number of losses.
 *  
 * Time Complexity: O(nlogn)
 * */

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
        List<Integer> undefeated = new ArrayList<Integer>();
        List<Integer> oneLoss = new ArrayList<Integer>();
        List<List<Integer>> sol = new ArrayList<List<Integer>>();

        for (int i = 0; i < matches.length; i++) {
            if (record.containsKey(matches[i][0]) == false) {
                record.put(matches[i][0], 0);
            }
            record.put(matches[i][1], record.getOrDefault(matches[i][1], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : record.entrySet()) {
            if (e.getValue() == 0) {
                undefeated.add(e.getKey());
            }
            else if (e.getValue() == 1) {
                oneLoss.add(e.getKey());
            }
        }

        Collections.sort(undefeated);
        Collections.sort(oneLoss);
        sol.add(undefeated);
        sol.add(oneLoss);

        return sol;
    }
}