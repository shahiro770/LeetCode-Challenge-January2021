/*
 * Best Team With No Conflicts
 *
 * Top 100% (0ms) 
 * 
 * Weird DP question that boils down to trying all combinations.
 * 1) Sort the players by age and score (if a score tie, lowest score first) in ascending order
 * 2) Your DP[n] iterates over the players from 0 to n, dp[i] = highest possible score using a subsequence
 * of players from 0 to i
 *      2.1) Iterate again for each iteration, 0 to j, where j = i
 *      2.2) During this process, we see if using the highest score achieved by a previous subsequence can be
 *      included with the current player 
 *          As long as players[j] has a lower score than players[i], the implication is dp[j] is comprised 
 *          of players with scores < players[j], therefore the team subsequence for dp[j] can include players[i]
 *              1) Notice that dp[j] is not necessarily the highest scoring team comp. ans stores the highest value,
 *              which means if steph curry at players[0] out scores a team comprised of the next 5 guys, that 
 *              value will be preserved. 
 *              2) Likewise if the next 6 guys out score steph curry, the global highest will be updated
 *          
 * Time Complexity: O(n^2);
 */

class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {
            players[i] = new Player(scores[i], ages[i]);
        }
        Arrays.sort(players);

        int[] dp = new int[n];
        int ans = 0;

        for (int i = 0; i < dp.length; i++) {
            dp[i] = players[i].score;

            for (int j = 0; j < i; j++) {
                if (players[j].score <= players[i].score) {
                    dp[i] = Math.max(dp[i], dp[j] + players[i].score);
                }
            }

            ans = Math.max(dp[i], ans);
        }

        return ans;
    }

    private class Player implements Comparable<Player> {
        int score;
        int age;

        private Player(int score, int age) {
            this.score = score;
            this.age = age;
        }

        public int compareTo(Player other) {
            if (this.age < other.age || this.age > other.age) {
                return this.age - other.age;
            }
            else {
                return this.score - other.score;
            }
        }
    }
}