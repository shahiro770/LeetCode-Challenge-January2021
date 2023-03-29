/*
 * Naming a company
 * 
 * Top 54% (183ms) 
 * 
 * Put each suffix in groups based on the first letter. The number of company names that can
 * be formed between any two groups is equal to the number in each less the common suffi, multiplied by 2
 * to account for the company names swapping the first and last words.
 * 
 * Time Complexity: n * m to hash m strings of length n, constant 26 * 26 * n to do the iteration and check
 * if each of the n words is in another letter set. In summary O(n * m) due to the hashing being the dominant
 * factor.
 */

class Solution {
    public long distinctNames(String[] ideas) {
        HashSet<String>[] suffix = new HashSet[26];
        long sol = 0;

        for (int i = 0; i < 26; i++) {
            suffix[i] = new HashSet<String>();
        }

        for (int i = 0; i < ideas.length; i++) {
            suffix[ideas[i].charAt(0) - 'a'].add(ideas[i].substring(1));
        }

        for (int i = 0; i < 26; i++) {
            HashSet<String> setI = suffix[i];
            for (int j = i + 1; j < 26; j++) {
                int numMutual = 0;
                HashSet<String> setJ = suffix[j];
                for (String s : setJ) {
                    if (setI.contains(s)) {
                        numMutual++;
                    }
                }
                sol += (setI.size() - numMutual) * (setJ.size() - numMutual) * 2;
            }
        }

        return sol;
    }
}