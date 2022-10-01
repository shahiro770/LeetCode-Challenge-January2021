/*
 * Design Circular Queue
 * 
 * September 2022
 * Top 91% (4ms)
 * 
 * Use an array as the underlying structure. Loop around to the start of the array
 * when the queue positions reach the end
 * 
 * Time complexity: N/A
 * 
 * */

class MyCircularQueue {
    private int[] queue;
    private int capacity;   // max number of elements in the queue
    private int size;       // number of elements in the queue
    private int tailPos = 0;
    private int headPos = 0;
    
    public MyCircularQueue(int k) {
        capacity = k;
        queue = new int[capacity];
    }
    
    public boolean enQueue(int value) {
        // special case; the head and tail will point to the same spot when the list is empty
        if (size == 0) {
            queue[tailPos] = value;   
            size++;
            return true;
        }
        else if (size < capacity) {
            tailPos = (tailPos + 1) % capacity;
            queue[tailPos] = value;   
            size++;
            return true;
        }
        
        return false;
    }
    
    public boolean deQueue() {
        // special case; the head and taill will point to the same spot when the list only has one element 
        if (size == 1) {
            queue[headPos] = 0;
            size--;
            return true;
        }
        else if (size > 0) {
            size--;    
            queue[headPos] = 0;
            headPos = (headPos + 1) % capacity;
            return true;
        }
        
        return false;
    }
    
    public int Front() {
        if (size > 0) {
            return queue[headPos];
        }
        
        return -1;
    }
    
    public int Rear() {
        if (size > 0) {
            return queue[tailPos];
        }
        
        return -1;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/*
["MyCircularQueue","Rear","Front","enQueue","Rear","Front","deQueue","Front","Rear","deQueue"]
[[5],[],[],[3],[],[],[],[],[],[]]
*/

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */