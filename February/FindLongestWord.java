/**
 * Feb 2021 Day 22
 * Top 36% because i don't understand this question
 * 
 * Sort the list then test to see if any word is a subsequence of the string
 * 
 * Time Complexity: nlogn to sort the list, and then 
*/

class Solution {
    public String findLongestWord(String s, List<String> d) {
        
        List<String> longestWords = new ArrayList<String>();
        char[] chars = s.toCharArray();
        
        Collections.sort(d, new StringComparer());
        
        for (int i = 0; i < d.size(); i++) {
            String currWord = d.get(i);
            int currWordIndex = 0;
            //System.out.println(currWord);
            for (int j = 0; j < s.length(); j++) {
                
                if (s.charAt(j) == currWord.charAt(currWordIndex)) {
                    currWordIndex++;
                    if (currWordIndex == currWord.length()) {
                        return currWord;
                    }
                }
            }
        }
        
        return "";
    }
    
    private class StringComparer implements Comparator<String> {
        public int compare(String s1, String s2) {
            if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            }
            else {
                return (s2.length() - s1.length());
            }
        }
    }
}