/*
 * Group Anagrams
 * 
 * September 2022
 * Top 96% (7ms)
 *
 * Sort the strings to get common keys, then add the anagrams to their corresponding buckets in the maps
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> sol = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        for (int i = 0 ; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String sortedStr = new String(c);

            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(strs[i]);
            }
            else {
                ArrayList<String> anaList = new ArrayList<String>();
                anaList.add(strs[i]);
                map.put(sortedStr, anaList);
            }
        }

        for (Map.Entry<String, ArrayList<String>> e : map.entrySet()) {
            sol.add(e.getValue());
        }

        return sol;
    }
}