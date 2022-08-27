/**
 * My Calendar I
 * Aug 2022 Day 3
 * 
 * Top 56% (34ms) 
 * 
 * Learned what a treemap is (map that keeps the keys in sorted order via a red black binary tree).
 * 
 * You can only add an interval if it doesn't conflict with another interval.
 * You could loop through all intervals in a list to see which ones conflict (I did this first,
 * got like bottom 9%), or you could abuse some kind of self-sorting data structure. Why?
 * 
 * The only interval you need to check for conflicts is the previous interval. Why?
 *      
 * 1. Since the list cannot have conflicts, all other intervals are not conflicting.
 * 2. If the new interval starts before the previous, then the end time needs to also
 * be before the start.
 * 
 * This is where the treep map comes in. It has the method lowerKey(K key) that gets you the NEXT
 * strictly lower key. If you construct your map such that <low,high>  is your key value pairings,
 * you can check if there's a conflict as described above.
 * 
 * Time Complexity: (O(logn)) as lowerKey is searching a binary tree as well as get()
 */
class MyCalendar {
    private TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer low = map.lowerKey(end);

        if (low == null || map.get(low) <= start) {
            map.put(start, end);
            return true;
        }
        
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */