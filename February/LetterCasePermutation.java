/**
 * Feb 2021 Day 16
 * Whenever you have a nondigit, you gain another "branch" with the lowercase and uppercase versions of the string
 * being put back into your queue for that index to repeat the process
 * It kinda works like a BFS.
 * 
 * Time complexity should be O(nlogn) (n characters, each doubling up to n times)
*/

class Solution {
    public List<String> letterCasePermutation(String S) {        
        Deque<String> currWords = new ArrayDeque<String>();
        int index = 0;
        int length = S.length();
        currWords.add(S);

        while (currWords.size() > 0 && index < length) {
            int size = currWords.size();
            for (int i = 0; i < size; i++) {
                if (Character.isDigit(S.charAt(index)) == false) {
                    char[] word = currWords.poll().toCharArray();
                    word[index] = Character.toUpperCase(word[index]);
                    currWords.add(String.valueOf(word));
                    word[index] = Character.toLowerCase(word[index]);
                    currWords.add(String.valueOf(word));
                }
            }
            index++;
        }
            
        return new ArrayList(currWords);
    }
}