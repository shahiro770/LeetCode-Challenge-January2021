/*
 * Copy List with Random Pointer
 * 
 * Top 100% (0ms)
 * 
 * Tricky mapping problem with linked list. 
 * 
 * Time Complexity: O(n)
 */

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node newHead = new Node(head.val);
        Node newCurr = newHead;
        Node curr = head;

        int index = 0;
        // maps the old nodes to their index
        HashMap<Node, Integer> oldNodeMap = new HashMap<Node, Integer>();
        // maps the index to the new nodes
        HashMap<Integer, Node> newNodeMap = new HashMap<Integer, Node>();
        // this simplifies the null checks for later
        oldNodeMap.put(null, -1);
        newNodeMap.put(-1, null);

        while (curr != null) {
            oldNodeMap.put(curr, index);
            newNodeMap.put(index, newCurr);
            index++;
            if (curr.next != null) {
                newCurr.next = new Node(curr.next.val);
            }

            curr = curr.next;
            newCurr = newCurr.next;
        }

        newCurr = newHead;
        curr = head;
        /**
            Check the oldNodeMap for the index of their random nodes.
            Then look at the newNodeMap with that index to get the new node that 
            the current node's random needs to point to
         */
        while (curr != null) {
            newCurr.random = newNodeMap.get(oldNodeMap.get(curr.random));
            curr = curr.next;
            newCurr = newCurr.next;
        }

        return newHead;
    }
}