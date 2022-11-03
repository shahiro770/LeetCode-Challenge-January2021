/*
 * Minimum Genetic Mutation
 *
 * Top 92% (1ms)
 * 
 * Time Complexity: O(n^2)
 */

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        map.put(start, new ArrayList<String>());
        for (int i = 0; i < bank.length; i++) {  
            if (isDiffByOne(start, bank[i])) {
                map.get(start).add(bank[i]);
            }
        }
        for (int i = 0; i < bank.length; i++) {
            if (!start.equals(bank[i])) {
                map.put(bank[i], new ArrayList<String>());
                for (int j = 0; j < bank.length; j++) {
                    if (isDiffByOne(bank[i], bank[j])) {
                        map.get(bank[i]).add(bank[j]);
                    }
                }
            }
        }

        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        int dist = 0;

        while (q.size() > 0) {
            int iteration = q.size();
            for (int j = 0; j < iteration; j++) {
                String curr = q.poll();
                if (curr.equals(end)) {
                    return dist;
                }
                if (map.containsKey(curr)) {
                    for (int i = 0; i < map.get(curr).size(); i++) {
                        q.offer(map.get(curr).get(i));
                    }
                    map.remove(curr);
                }
            }
            dist++;
        }
        return -1;
    }

    public boolean isDiffByOne(String a, String b) {
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        int diffCount = 0;

        for (int i = 0; i < ac.length; i++) {
            if (ac[i] != bc[i]) {
                diffCount++;
            }
        }

        return diffCount == 1;
    }
}