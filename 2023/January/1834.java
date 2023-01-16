/*
 * Single-Threaded CPU
 * 
 * Top 91% (123ms)
 * 
 * Sort the tasks by start time, then feed them into a min heap based on shortest processing time (or index if there's a tie).
 * At each iteration you process a task and update the current time. Add tasks with a start time before the current time and 
 * repeat until all tasks are processed.
 * 
 * Time Complexity: O(nlgn)
 */

class Solution {
    public int[] getOrder(int[][] tasks) {
        int[][] tasksModified = new int[tasks.length][3];

        for (int i = 0; i < tasks.length; i++) {
            tasksModified[i][0] = tasks[i][0];
            tasksModified[i][1] = tasks[i][1];
            tasksModified[i][2] = i;
        }
        Arrays.sort(tasksModified, (a, b) -> {
            return a[0] - b[0];
        });

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> {
            if (a[1] == b[1]) {
                return a[2] - b[2];
            }
            return a[1] - b[1];
        });

        int[] sol = new int[tasksModified.length];
        int time = 0;
        int taskPos = 0;
        int solPos = 0;

        while (solPos < tasksModified.length) {
            // if the queue is empty and no tasks can be scheduled, jump to the time of the next task
            if (taskPos < tasksModified.length && pq.size() == 0 && tasksModified[taskPos][0] > time) {
                time = tasksModified[taskPos][0];
            }
            while (taskPos < tasksModified.length && time >= tasksModified[taskPos][0]) {
                pq.offer(tasksModified[taskPos]);
                taskPos++;
            }
            
            int[] currTask = pq.poll();
            sol[solPos] = currTask[2];
            solPos++;
            time += currTask[1]; 
        }

        return sol;
    }
}