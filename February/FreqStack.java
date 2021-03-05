/**
 * February 2021 Day 28
 * 
 * This is the solution from leetcode cause my own solution had a huge flaw of O(n) removal (BOTTOM 0% GANG)
 *      I have no idea how 1500ms time did not time out, but I can assure whoever is reading this I wasn't even on the graph
 * 
 * How this works:
 *      1) Make a hashmap, mapping each value in the stack to its frequence
 *      2) Make a hashmap, mapping each value with a given frequency to a stack, putting the value in the stack
 *          This way we'll know the last element to have a given frequency, maintaining the order in which it will be removed
 *      3) Track the current highest frequency, since this will determine which stack in the stackMap we'll remove from on pops
 *      4) Push
 *          Increment the frequency of a given value in the map
 *          If it beats the highest frequency, make it the highest frequency
 *          For the group with the corresponding frequency, push the value to that stack
 *      5) Pop 
 *          Pop from the stack with the highest frequency
 *          Update the frequency map
 *              Check the group with the highest frequency, if its empty, reduce the max frequency by 1
 *           
 * The end result is all operations having O(1) time
 */

class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxfreq;

    public FreqStack() {
        freq = new HashMap();
        group = new HashMap();
        maxfreq = 0;
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        if (f > maxfreq)
            maxfreq = f;

        group.computeIfAbsent(f, z-> new Stack()).push(x);
    }

    public int pop() {
        int x = group.get(maxfreq).pop();
        freq.put(x, freq.get(x) - 1);
        if (group.get(maxfreq).size() == 0)
            maxfreq--;
        return x;
    }
}
