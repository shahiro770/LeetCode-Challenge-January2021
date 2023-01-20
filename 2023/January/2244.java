/*
 * Minimum Rounds to Complete All Tasks
 * 
 * Top 90% (1ms)
 * 
 * Greed works for this problem since you always want to try and take out as many 3s before taking out any 2s.
 * Really, the only time you want to take out a 2 is if the remainder leaves you with:
 *  - Exactly 2 tasks left of the same difficulty
 *  - Exactly 4 tasks left (taking out a 3 will leave us with remainder 1 and seeming impossible when in reality it isn't)
 * 
 * Time Complexity: O(n)
 *
 * */

class Solution {
    public int minimumRounds(int[] tasks) {
        // count the frequency of each task, grouped by difficulty
        HashMap<Integer, Integer> taskFreq = new HashMap<Integer, Integer>();
        for (int i = 0; i < tasks.length; i++) {
            taskFreq.put(tasks[i], taskFreq.getOrDefault(tasks[i], 0) + 1);
        }

        int rounds = 0;    
        for (Map.Entry<Integer, Integer> e : taskFreq.entrySet()) {
            int val = e.getValue();
            int div3 = val / 3;
            int rem3 = val - div3 * 3;

            if (rem3 == 1 && div3 >= 1) {
                rounds += div3 + 1;     // remove a 3 and then take out two 2's
                continue;
            }

            int div2 = rem3 / 2;
            int rem2 = rem3 - div2 * 2;

            if (rem2 == 0) {
                rounds += div3 + div2;
            }
            else { 
                return -1;
            } 
        }

        return rounds;
    }
}