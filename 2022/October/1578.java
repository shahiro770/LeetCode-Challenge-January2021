/**
 * Decode Ways
 * 
 * October 2022
 * Top 97% (7ms)  
 * 
 * Whenever you see two duplicate colours back to back, iterate until you've found the end
 * of the duplicate chain, keeping track of the balloon that takes the most time to remove.
 * You'll remove every balloon in that chain except for the longest time balloon.
 * 
 * Time complexity: O(n)
 * */

class Solution {
    public int minCost(String colors, int[] neededTime) {
        char[] cs = colors.toCharArray();
        int left = 0;
        int right = 0;
        int totalTime = 0;
        while (right < cs.length - 1) {
            right++;

            if (cs[left] == cs[right]) {
                int longestTimeNeeded = neededTime[left];
                int totalDuplicateRemovalTime = neededTime[left];
                while (right < cs.length && cs[right] == cs[left]) {
                    totalDuplicateRemovalTime += neededTime[right];
                    longestTimeNeeded = Math.max(longestTimeNeeded, neededTime[right]);
                    right++;
                }
                totalTime += totalDuplicateRemovalTime - longestTimeNeeded;
            }

            left = right;   
        }

        return totalTime;
    }
}