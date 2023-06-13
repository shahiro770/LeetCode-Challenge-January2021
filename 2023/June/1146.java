/*
 * Snapshot Array
 *
 * Top 85% (64ms)
 * 
 * A big constraint, while somewhat expected,is  a memory limit will time you out if you try to just 
 * store copies of each array (surprisingly this won't time you out).
 * 
 * To work around the above, take advantage of the fact that all gets/sets on the fixed size array
 * are based on an index; we can just track the history of each value and update that history
 * on get() operations.
 * 
 * Ideally you have an array of maps, so for each index, the value is mapped to a snapId. But there's a catch here:
 * Suppose we had a snapMap of length 2. The following operations are called
 * set(0, 1)    // snapId = 0
 * snap()       
 * set(1, 1)    // snapId = 1
 * snap()
 * get(1, 0)
 * 
 * With our implementation, there is no value in the map for index 0 with a snapId of 1. We only update the history
 * on gets. The solution? Get the next lowest key of the requested snapId, as that would have been the value during
 * that snapshot. A treemap's floorEntry() method covers this situation. 
 * 
 * Time Complexity: O(lgn) for get, O(n) for array creation 
 */

class SnapshotArray {
    int[] arr;
    TreeMap<Integer, Integer>[] snapMap;
    int snapId;

    public SnapshotArray(int length) {
        snapId = 0;
        snapMap = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            snapMap[i] = new TreeMap<>();
            snapMap[i].put(snapId, 0);
        }  
    }
    
    public void set(int index, int val) {
        snapMap[index].put(snapId, val);
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        return snapMap[index].floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */