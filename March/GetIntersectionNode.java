/**
 * March 2021 Day 4
 * 
 * 1ms time most of the time (might be 2ms if bad luck) so top 97.5%
 * O(n) solutions come in two flavours
 *      1) Make some kind of storage based off the first list, 2nd list just compare against the stored memory addresses
 *          You can either do this by:
 *              Storing the 2nd list and then comparing from the tail
 *              Throwing the values of the 1st list into some kind of hashtable data structure to quickly compare all B values
 *      2) Get the lists to align somehow
 *          Clearly if you found out the lengths of both lists, then you just need to test after the lists line up
 *              By definition of intersection they'll need to have the same number of elements remaining after intersection
 *                  So get the lengths of both lists, subtract the difference and move the curr pointer on the larger up by the difference
 *                      From there compare
 *          You could also do this wacky loop strategy by making the list pointer point to each other on hitting null the first time
 *              This also solves the offset problem
 * 
 * Time complexity: O(n)
 * Space complexity: O(n) if bad, O(1) if smart
 */


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int movesA = 0;
        int movesB = 0;
        ListNode currA = headA;
        ListNode currB = headB;
        ArrayList<ListNode> as = new ArrayList<ListNode>();
        ArrayList<ListNode> bs = new ArrayList<ListNode>();
        
        while (currA != null) {
            as.add(currA);
            currA = currA.next;
        }
        while (currB != null) {
            bs.add(currB);
            currB = currB.next;
        }
        
        ListNode prev = null;
        int aIndex = as.size() - 1;
        int bIndex = bs.size() - 1;
        while (aIndex >= 0 && bIndex >= 0 && as.get(aIndex) == bs.get(bIndex)) {
            prev = as.get(aIndex);
            aIndex--;
            bIndex--;
        }
        
        return prev;
    }
}

/** O(1) memory usage
 * public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int lenA = 0;
        int lenB = 0;
        while (nodeA.next != null) {
            nodeA = nodeA.next;
            lenA++;
        }
        while (nodeB.next != null) {
            nodeB = nodeB.next;
            lenB++;
        }
        if (nodeA != nodeB) {
            return null;
        }
        nodeA = headA;
        nodeB = headB;
        if (lenA > lenB) {
            int diff = lenA - lenB;
            while (diff > 0) {
                nodeA = nodeA.next;
                diff--;
            }
        } else if (lenB > lenA) {
            int diff = lenB - lenA;
            while (diff > 0) {
                nodeB = nodeB.next;
                diff--;
            }
        }
        
        while (nodeA != nodeB) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return nodeA;
    }
}
 */