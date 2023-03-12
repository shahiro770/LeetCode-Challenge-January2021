/*
 * LFU Cache
 *
 * Top 93% (56ms) 
 * 
 * The underlying structure is to have linked lists mapped to each frequency.
 * 1 -> [node1, node2, ...]
 * 2 -> [node3, ...]
 * 3 -> [node4, ...]
 * 
 * With the front representing the oldest node in the frequency and the tail representing the youngest.
 * By having the nodes keep track of their prev/next, as long as you can reference it at O(1) time, you can
 * remove the node from its current frequency at O(1) time, and/or promote it to the next frequency.
 * Use a map from the node's key values to the nodes to be able to do this (since the nodes are referenced by keys
 * in all method calls).
 * 
 * Time Complexity: O(1) for all operations
 */

class LFUCache {
    int capacity;
    int size;
    int minFreq;
    HashMap<Integer, Node> nodeMap;
    HashMap<Integer, DoubleLinkedList> freqMap;

    private class Node {
        int key;
        int val;
        int freq = 1;
        Node prev;
        Node next;

        private Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private class DoubleLinkedList {
        int size;
        Node head;
        Node tail;

        private DoubleLinkedList() {
            size = 0;
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        private void add(Node n) {
            tail.prev.next = n;
            n.prev = tail.prev;
            n.next = tail;
            tail.prev = n;
            this.size++;
        }

        private void remove(Node n) {
            n.prev.next = n.next;
            n.next.prev = n.prev;
            this.size--;
        }

        // used to remove the LFU, covering the case if there's a tie on the same frequency by design
        private void removeHead() {
            nodeMap.remove(head.next.key);
            remove(head.next);
        }
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        minFreq = 1;
        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        Node n = nodeMap.get(key);
        if (n == null) {
            return -1;
        }
        update(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        Node n = nodeMap.get(key);
        // node already exists, update its key and frequency
        if (n != null) {
            n.val = value;
            update(n);
        }
        // node doesn't exist and there's room, create a new node on frequency 1
        else if (size < capacity) {
            n = new Node(key, value);
            if (freqMap.get(n.freq) == null) {
                freqMap.put(n.freq, new DoubleLinkedList());
            }
            freqMap.get(n.freq).add(n);
            nodeMap.put(key, n);
            minFreq = n.freq;
            size++;
        }
        // node doesn't exist and there's no room, remove LFU and add it
        else if (size == capacity && capacity > 0) {  // if capacity is 0, we can't do anything, otherwise remove the LFU and add the new node
            // this method also assumes the freq 1 DLL exists (which has to if capacity > 0 and we've reached max capacity)
            freqMap.get(minFreq).removeHead();

            n = new Node(key, value);
            freqMap.get(n.freq).add(n);
            nodeMap.put(key, n);
            minFreq = n.freq;
        }
    }

    // updates the frequency of a node, promoting it to the next freq
    public void update(Node n) {
        freqMap.get(n.freq).remove(n);
        n.freq++;
        // update the minFreq if the node to be updated would be the last one with that frequency
        if (minFreq == n.freq - 1 && freqMap.get(n.freq - 1).size == 0) {
            minFreq = n.freq;
        }
        // create the next frequency DLL if it doesn't exist
        if (freqMap.get(n.freq) == null) {
            freqMap.put(n.freq, new DoubleLinkedList());
        }
        freqMap.get(n.freq).add(n);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */