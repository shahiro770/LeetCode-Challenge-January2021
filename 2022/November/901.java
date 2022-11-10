/*
 * Online Stock Span
 *
 * Top 96% (43ms) 
 * 
 * Whenever a new stock gets added, all we care about is how any stocks before it had value less than it.
 * To maintain this information, each new stock just needs to know how many it beat prior, and then
 * we can throw away those defeated stocks. This leads to the use of a montonically increasing stack.
 * 
 * Time Complexity: O(n)
 */

class StockSpanner {
    int pos;
    Deque<Node> stack;

    public StockSpanner() {
        stack = new LinkedList<Node>();
        pos = 0;
    }
    
    public int next(int price) {
        int c = 1;
        while (stack.size() > 0 && price >= stack.peek().price) {
            c += stack.pop().less;
            
        }
        stack.push(new Node(price, c));

        return stack.peek().less;
    }

    private class Node {
        int price;
        int less;

        private Node(int price, int less) {
            this.price = price;
            this.less = less;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */