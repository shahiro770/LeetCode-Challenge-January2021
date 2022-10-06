
/**
 * Time Based Key-Value Store
 * 
 * October 2022
 * Top 88% (188ms)  
 * 
 * Map that maps the key to a Treemap that maps timestamps to the values. Use the treemap to keep keys in order.
 *
 * Time complexity: O(n)
 * */

class TimeMap {
    HashMap<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<String, TreeMap<Integer, String>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            TreeMap<Integer, String> mapmap = map.get(key);
            mapmap.put(timestamp, value);
        }
        else {
            TreeMap<Integer, String> mapmap = new TreeMap<Integer, String>();
            mapmap.put(timestamp, value);
            map.put(key, mapmap);
        }
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> mapmap = map.get(key);
        if (mapmap.firstKey() > timestamp) {
            return "";
        }
        if (mapmap.containsKey(timestamp)) {
            return mapmap.get(timestamp);
        }
        return mapmap.get(mapmap.lowerKey(timestamp));
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */