/*
 * IPO
 * 
 * Top 87% (109ms)
 * 
 * Jeffrey made me do this. In under 20 minutes!!
 * 
 * Time complexity: O(nlogn) because sorting + heap
 */

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            return b[1] - a[1];
        });

        int[][] projects = new int[profits.length][2];
        
        for (int i = 0; i < profits.length; i++) {
            projects[i] = new int[] {capital[i], profits[i]};
        } 

        Arrays.sort(projects, (a, b) -> {
            return a[0] - b[0];
        });

        int projectsTaken = 0;
        int totalCapital = w;
        int index = 0;

        while (projectsTaken < k) {
            while (index < projects.length && projects[index][0] <= totalCapital) {
                maxHeap.offer(projects[index]);
                index++;
            }
            if (maxHeap.size() > 0) {
                int[] bestProject = maxHeap.poll();
                totalCapital += bestProject[1];
                projectsTaken++;
            }
            else {
                break;
            }
        }

        return totalCapital;
    }
}