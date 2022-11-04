/**
 * Earliest Possible Day of Full Bloom
 *
 * Top 96% (19ms)
 *
 * Two things that lets us be greedy:
 * 1) Its always best to be planting as often as possible (to multitask while other things are growing)
 * 2) The longer something takes to the grow, the earlier it should be planted
 * 
 * If we were to sort the list of seeds in order of longest growing time to shortest,
 * this naively says the total time taken should equal the sum of all planting time + the longest
 * growing time. 
 * 
 * However, it may be the case that a plant planted halfway through alotted days
 * may finish growing later than the first plant. In other words, we need to constantly check
 * if a given plant's growing time + the current total planting time exceeds the current total time
 * estimate.
 * 
 * Time Complexity: O(nlogn)
 */

class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        Seed[] seeds = new Seed[plantTime.length];

        for (int i = 0; i < plantTime.length; i++) {
            seeds[i] = new Seed(plantTime[i], growTime[i]);
        }

        Arrays.sort(seeds);

        int plantingDays = 0;
        int totalDays = 0;

        for (int i = 0; i < seeds.length; i++) {
            plantingDays += seeds[i].plant;
            totalDays = Math.max(totalDays, plantingDays + seeds[i].growth);
        }

        return totalDays;
    }

    private class Seed implements Comparable<Seed> {
        int plant = 0;
        int growth = 0;

        private Seed(int plant, int growth) {
            this.plant = plant;
            this.growth = growth;
        }

        @Override
        public int compareTo(Seed otherSeed) {
            if (otherSeed.growth == growth) {
                return otherSeed.plant - plant;
            }
            return otherSeed.growth - growth;   // descending growth
        }
    }
}