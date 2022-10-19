/**
 * Min Stack
 * 
 * Top 97% (4ms)
 * 
 * Have each node in the stack store the min value up until that point, returning the top's min when asked.
 * New nodes get pushed and get a new min if possible. The min for lower nodes never change, since
 * if we ever were to check their mins, the nodes above that might've impacted them had to have been removed.
 * 
 * Time Complexity: O(1) for all operations
 * */

class MinStack {
    ArrayList<StackNode> stack;
    int min = Integer.MAX_VALUE;
    int index = -1;

    public MinStack() {
        stack = new ArrayList<StackNode>(30000);
    }
    
    public void push(int val) {
        if (val < min) {
            min = val;
        }
        stack.add(new StackNode(val, min));
        index++;
    }
    
    public void pop() {
        if (index > 0) {
            min = Math.max(stack.get(index).min, stack.get(index - 1).min);
            stack.remove(index);
            index--;
        }
        else if (index > -1) {
            min = Integer.MAX_VALUE;
            stack.remove(index);
            index--;
        }
    }
    
    public int top() {
        if (index == -1) {
            return 0;
        }
        return stack.get(index).val;
    }
    
    public int getMin() {
        return stack.get(index).min;
    }

    private class StackNode {
        int val;
        int min;

        private StackNode(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */