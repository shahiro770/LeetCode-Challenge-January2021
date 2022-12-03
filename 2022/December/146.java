/**
 * LRU Cache
 *
 * Top 87% (68ms)
 * 
 * The easy to arrive at idea is using a linked list to keep track of what was just added,
 * and using a hashmap for an O(1) access time for any element.
 * The hard part is updating the recently used, as it could be anywhere in your linked list.
 * The trick is to have a hashmap that references the nodes in a doubly linked list, so you
 * can maintain the cache at O(1) time.
 * 
 * 
 * Time Complexity: O(1) 
 */

class LRUCache {
    Node head;  // the linked list is used solely for remembering the least recently used
    Node tail;
    HashMap<Integer, Node> map; // the map contains key to node mappings
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        // for convenience of not having to manage the head and tail pointers not being null
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    // returns the value of the node with the key
    public int get(int key) {
        // if the map already has it, remove the value from the linked list and add it back to the end
        if (map.containsKey(key)) {
           remove(map.get(key));
           add(map.get(key));

           return map.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // if the map already has it, remove the value from the linked list and add it back to the end
        if (map.containsKey(key) ) {
            remove(map.get(key));
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        add(newNode);
        
        if (map.size() > capacity) {
            // remove from the list and delete the LRU from the hashmap
            Node lru = head.next;
            remove(lru);
            map.remove(lru.key);
        }
    }

    // adds the node to the linked list
    private void add(Node n) {
        Node prev = tail.prev;
        Node next = tail;

        prev.next = n;
        next.prev = n;

        n.next = next;
        n.prev = prev;
    }

    // removes the node from the linked list
    private void remove(Node n) {
        Node prev = n.prev;
        Node next = n.next;

        prev.next = next;
        next.prev = prev;
    }

    private class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);

 A,B,C,D

 B,C,D,A

 B,C,A,D
 */