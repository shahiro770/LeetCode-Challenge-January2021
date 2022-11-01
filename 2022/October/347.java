/**
 * Top K Frequent Words
 * 
 * Top 99% (5ms)
 * 
 * Put it in a map, and then put the map in a priority queue/max heap
 * 
 * Time Complexity: O(nlogk), where k is the number elements that are needed in the solution.
 * n elements are put into the hash map, and then again into pq, but then we will remove k elements,
 * which will take logk time. 
 * */

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        PriorityQueue<Pair<String, Integer>> pq = new PriorityQueue<Pair<String, Integer>>((a, b) -> {
            if (a.getValue() == b.getValue()) {
                return a.getKey().compareTo(b.getKey());
            }
            return b.getValue() - a.getValue();
        });
        List<String> sol = new ArrayList<String>();

        for (Map.Entry e : map.entrySet()) {
            pq.offer(new Pair(e.getKey(), e.getValue()));
        }
        for (int i = 0; i < k; i++) {
            sol.add(pq.poll().getKey());
        }

        return sol; 
    }
}