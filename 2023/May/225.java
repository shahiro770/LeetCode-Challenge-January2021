/*
 * Implement Stack using Queues
 *
 * Top 100% (0ms)
 *
 * Single stack solutions exist (e.g. just keep dequeuing and enqueuing for size - 1 to get the element)
 * but its no big deal.
 * 
 * Time Complexity: O(n) for pop O(1) for everything else
 */

class MyStack {
    Deque<Integer> stack;
    Deque<Integer> stack2;

    public MyStack() {
        stack = new ArrayDeque<Integer>();
        stack2 = new ArrayDeque<Integer>();
    }
    
    public void push(int x) {
        stack.addLast(x);
    }
    
    public int pop() {
        if (empty() == false) {
            while (stack.size() > 1) {
                stack2.addLast(stack.removeFirst());
            }
            int toReturn = stack.removeFirst();
            Deque<Integer> temp = stack;
            stack = stack2;
            stack2 = temp;

            return toReturn;
        }
        return -1;
    }
    
    public int top() {
        return stack.peekLast();
    }
    
    public boolean empty() {
        return stack.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */