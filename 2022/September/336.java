/**
 * Palindrome Pairs
 * 
 * September 2022
 * Top 90% (253ms)
 * 
 * This question is messed. Answer is borrowed from https://leetcode.com/problems/palindrome-pairs/discuss/2596483/Simple-Java-Solution
 * because I couldn't pass all test cases with my solution and don't know why.
 * 
 * This solution doesn't even use tries?!?!
 * 
 * Time complexity: Don't want to think about it
 */


class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
        Set<Integer> set = new TreeSet<Integer>(); // integer default sorting is ascending
        int n = words.length;
        
        
        for(int i = 0; i < n; i++){
            wordMap.put(words[i], i);    // store each word and its index
            set.add(words[i].length());
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            int length = words[i].length();
            
            // edge case with word length being 1, just check if empty string is there and 
            // you get two palindromes
            if (length == 1){
                if(wordMap.containsKey("")){
                    ans.add(Arrays.asList(i, wordMap.get("")));
                    ans.add(Arrays.asList(wordMap.get(""), i));
                }
                continue;
            }

            // if the reverse is contained in the word map that is an easy palindrome
            String reverse = new StringBuilder(words[i]).reverse().toString();
            if (wordMap.containsKey(reverse) && wordMap.get(reverse) != i) {
                ans.add(Arrays.asList(i,wordMap.get(reverse)));
            }

            // Suffix and prefix testing
            for (Integer k :set) {

                // by definition these strings must be smaller to have the current string as a suffix/prefix
                if (k == length) {
                    break;
                }
                // Testing prefix (example)
                // string: "llsss", reverse: "sssll"
                // Check if "ll" is a palindrome from the reverse
                // If so, see if "sss" is in the dictionary, since "sssllsss" is a palindrome
                if (isPalindrome(reverse, k, length - 1)) {
                    String s1 = reverse.substring(0, k);
                    if(wordMap.containsKey(s1)){
                        ans.add(Arrays.asList(wordMap.get(s1),i));
                    }
                }

                // Testing suffix (example)
                // string: "sssll", reverse: "llsss"
                // Check if "ll" is a palindrome from the reverse
                // If so, see if "sss" is in the dictionary, since "sssllsss" is a palindrome
                if (isPalindrome(reverse, 0, length - 1 - k)){
                    String s2 = reverse.substring(length - k);
                    if (wordMap.containsKey(s2)) {
                        ans.add(Arrays.asList(i,wordMap.get(s2)));
                    }
                }
            }
        }

        return ans;
    }
    
    private boolean isPalindrome(String s, int left, int right){
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}