/*
 * Implement Queue using Stacks
 * 
 * Top 100% (0ms)
 *
 * You can create a queue by popping off all the values in one stack to another.
 * The only catch is, wait for that "queue stack" to be empty before doing so again,
 * otherwise it will mess up the order.
 * 
 * Doing so periodically (i.e. before peeking or popping) will make the amortized time of all operations
 * O(1).
 * 
 * Time Complexity: O(n)
 */

class MyQueue {
    Deque<Integer> entryStack;
    Deque<Integer> exitStack;

    public MyQueue() {
        entryStack = new ArrayDeque<Integer>();
        exitStack = new ArrayDeque<Integer>();
    }
    
    public void push(int x) {
        entryStack.push(x);
    }
    
    public int pop() {
        if (exitStack.size() == 0) {
            while (entryStack.size() > 0) {
                exitStack.push(entryStack.pop());
            }
        }
        return exitStack.pop();
    }
    
    public int peek() {
        if (exitStack.size() == 0) {
            while (entryStack.size() > 0) {
                exitStack.push(entryStack.pop());
            }
        }
        return exitStack.peek(); // top
    }
    
    public boolean empty() {
        return entryStack.size() == 0 && exitStack.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

 /*
    3    1
    2 -> 2
    1    3    
    
 */class MyQueue {
    Deque<Integer> entryStack;
    Deque<Integer> exitStack;

    public MyQueue() {
        entryStack = new ArrayDeque<Integer>();
        exitStack = new ArrayDeque<Integer>();
    }
    
    public void push(int x) {
        entryStack.push(x);
    }
    
    public int pop() {
        if (exitStack.size() == 0) {
            while (entryStack.size() > 0) {
                exitStack.push(entryStack.pop());
            }
        }
        return exitStack.pop();
    }
    
    public int peek() {
        if (exitStack.size() == 0) {
            while (entryStack.size() > 0) {
                exitStack.push(entryStack.pop());
            }
        }
        return exitStack.peek(); // top
    }
    
    public boolean empty() {
        return entryStack.size() == 0 && exitStack.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

 /*
    3    1
    2 -> 2
    1    3    
    
 */