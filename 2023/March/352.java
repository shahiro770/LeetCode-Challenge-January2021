/*
 * Data Stream as Disjoint Intervals
 *
 * Top 99% (21ms) 
 * 
 * The dumb way to go about this is like a typical merge intervals question, but if you do that
 * every insertion is going to be O(n) time and you feel pain.
 * 
 * Instead use a treeMap, so upon any insertion:
 *  1) We know if there's a value in the intervals less or greater than the value in O(lgn) time thanks to the lower/higher key method
 *  2) We can do merge logic based on the above
 * 
 * Time Complexity: O(lgn) for adding, O(n) for getting the intervals
 */

class SummaryRanges {
    // key represents the start/lower value in the interval
    TreeMap<Integer, int[]> map;

    SummaryRanges() {
        map = new TreeMap<>();
    }
    
    void addNum(int value) {
        // don't double insert in the value
        if (map.containsKey(value) == false) {
            Integer low = map.lowerKey(value);
            Integer high = map.higherKey(value);

            // if a lower interval and higher interval both exist, and the inserted value
            // is directly inbetween where the lower interval ends and the higher begins
            if (low != null && high != null
            && map.get(low)[1] + 1 == value && value + 1 == high) {
                map.get(low)[1] = map.get(high)[1];
                map.remove(high);
            }
            // if the lower interval encompasses the value, do nothing
            // however if it could be extended by 1, do that instead
            else if (low != null && map.get(low)[1] + 1 >= value) {
                map.get(low)[1] = Math.max(map.get(low)[1], value);
            }
            // if the value could be merged with the start of the higher interval,
            // merge it (need to re-insert it into the map due to the key being the start)
            else if (high != null && value + 1 == high) {
                map.get(high)[0] = value;
                map.put(value, map.get(high));
                map.remove(high);
            }
            else {
                map.put(value, new int[] {value, value});
            }
        }
    }
    
    public int[][] getIntervals() {
        List<int[]> intervals = new ArrayList<int[]>(map.values());
        return intervals.toArray(new int[intervals.size()][]);
    }
}
