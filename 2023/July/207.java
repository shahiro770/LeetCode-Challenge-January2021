/*
 * Course Schedule
 *
 * Top 69% (5ms) ayy
 * 
 * Topological sort is kinda interesting. Instead of a typical visited[], you need to count the number of incoming edges.
 * Any node with 0 incoming edges can be put in the BFS/DFS start. 
 * 
 * Time Complexity: O(V + E) 
 * 
 */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
        int[] preReqCount = new int[numCourses];

        // build hte graph
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<Integer>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            preReqCount[prerequisites[i][0]]++;
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);    // add the  course as an outgoing edge to the prereq course
        }

        // get the courses we can take without any prereqs
        Deque<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < preReqCount.length; i++) {
            if (preReqCount[i]  == 0) {
                queue.offer(i);
                numCourses--;
            }
        }

        // bfs
        while (queue.size() > 0) {
            int currCourse = queue.poll() ;
            ArrayList<Integer> reqs = graph.get(currCourse);
             
            for (int j = 0; j < reqs.size(); j++) {
                int course = reqs.get(j);
                preReqCount[course]--;
                if (preReqCount[course] == 0) {
                    queue.offer(course);
                    numCourses--;
                }
            }
        }

        return numCourses == 0;
    }
}