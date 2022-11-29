/**
 * Insert Delete GetRandom O(1)
 * 
 * Top 87% (33ms)
 * 
 * The whole problem is the random removal:
 * 1) You can't O(1) access a random element in a hashmap based on index
 * 2) You can't O(1) remove a specific element in a list as that causes shifting the list back (worst case O(n))
 * 3) You can't O(1) check if a list contains a specific element
 * 
 * The trick is to manipulate condition 2). Suppose we used a hashmap to keep
 * track of the index of each element in the the list. If whenever we wanted to remove an element,
 * we swap it with the element at the end of the list and then pop it (updating the swapped element's
 * position in the map)
 * 
 * In doing so, we have an O(1) add and remove, can check if an element exists in O(1) time,
 * and can randomly select any value from within the list at O(1)
 * 
 * Time Complexity: O(1) on average
 * */

class RandomizedSet {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> keys = new ArrayList<Integer>();

    public RandomizedSet() {
        map = new HashMap<Integer, Integer>();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, keys.size());
        keys.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int tempLast = keys.get(keys.size() - 1);   // value at the end of the list
            int tempIndex = map.get(val);               // index in the keys list where the value to be removed is stored
            keys.set(tempIndex, tempLast);              // the old key is overwritten and essentially removed
            map.put(tempLast, tempIndex);
           
            keys.remove((int)(keys.size() - 1));        // remove the last value in the keys list
            map.remove(val);                            // remove the value in the map
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int index = new Random().nextInt(keys.size());
        return keys.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */