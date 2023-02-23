/**
 * Insert Interval
 *
 * Top 98% (1ms)
 * 
 * Annoying question. There's 4 cases:
 * 1) Interval ends before all the intervals, insert at the start
 * 2) Interval starts after the end of all intervals, insert at the end
 * 3) Interval is inbetween two intervals, insert in-between
 * 4) Interval overlaps with one or more intervals, merge them all 
 *
 * Time Complexity: O(n)
 */

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> sol = new ArrayList<int[]>();
        boolean added = false;

        // case 1
        if (intervals.length == 0 || newInterval[1] < intervals[0][0]) {
            sol.add(newInterval);
            added = true;
        }
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > newInterval[1] || intervals[i][1] < newInterval[0]) {
                sol.add(intervals[i]);
                // case 3
                if (added == false && i < intervals.length - 1
                && intervals[i][1] < newInterval[0] && intervals[i + 1][0] > newInterval[1]) {
                    sol.add(newInterval);
                    added = true;
                }
            }
            // case 4
            else if (added == false){
                int start = Math.min(intervals[i][0], newInterval[0]);
                int end = Math.max(intervals[i][1], newInterval[1]);
                while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
                    end = Math.max(intervals[i][1], newInterval[1]);;
                    i++;
                }
                i--;    // need to i-- because the i++ will make us skip the next interval after rejecting it from the merge
                sol.add(new int[] {start, end});
                added = true;
            }
        }
        // case 2
        if (added == false && newInterval[0] > intervals[intervals.length - 1][1]) {
            sol.add(newInterval);
            added = true;
        }

        int[][] solArray = new int[sol.size()][2];

        for (int i = 0; i < sol.size(); i++) {
            solArray[i] = sol.get(i);
        }

        return solArray;
    }
}

