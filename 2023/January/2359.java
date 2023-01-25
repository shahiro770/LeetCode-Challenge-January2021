/*
 * Find Closest Node to Given Two Nodes
 * 
 * Top 99% (9ms)
 * 
 * This question shouldn't even be labeled as DFS since there's only one outgoing edge at most per node.
 * Just count the distance from the starting node for both nodes until you reach a cycle or edgeless node.
 * Then run the distance calc on each node until you get the mini-max distance.
 *
 * Time Complexity: O(n)
 */

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] dist1 = new int[edges.length];
        int[] dist2 = new int[edges.length];

        int currNode = node1;
        int dist = 0;

        for (int i = 0; i < dist1.length; i++) {
            dist1[i] = -1;
            dist2[i] = -1;
        }

        while (dist1[currNode] == -1) {
            dist1[currNode] = dist;
            dist++;
            if (edges[currNode] != -1) {
                currNode = edges[currNode];
            }
            else {
                break;
            }
        }

        currNode = node2;
        dist = 0;
        while (dist2[currNode] == -1) {
            dist2[currNode] = dist;
            dist++;
            if (edges[currNode] != -1) {
                currNode = edges[currNode];
            }
            else {
                break;
            }
        }

        int sol = -1;
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < dist1.length; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                if (Math.max(dist1[i], dist2[i]) < minDist) {
                    sol = i;
                    minDist = Math.max(dist1[i], dist2[i]);
                }
            }
        }

        return sol;
    }
}
