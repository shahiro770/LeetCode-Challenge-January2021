/*
 * Keyboard Row
 *
 * Top 100% (0ms)
 * 
 * Time Complexity: O(n) where n is the number of characters 
 */

class Solution {
    public String[] findWords(String[] words) {
        ArrayList<String> sol = new ArrayList<String>();
        String row1Chars = "qwertyuiop";
        String row2Chars = "asdfghjkl";
        String row3Chars = "zxcvbnm";

        HashMap<Character, Integer> row1 = new HashMap<>();
        HashMap<Character, Integer> row2 = new HashMap<>();
        HashMap<Character, Integer> row3 = new HashMap<>();

        for (int i = 0; i < row1Chars.length(); i++) {
            row1.put(row1Chars.charAt(i), 0);
        }
        for (int i = 0; i < row2Chars.length(); i++) {
            row2.put(row2Chars.charAt(i), 0);
        }
        for (int i = 0; i < row3Chars.length(); i++) {
            row3.put(row3Chars.charAt(i), 0);
        }

        for (int i = 0; i < words.length; i++) {
            String currWord = words[i].toLowerCase();
            boolean valid = true;
            
            if (row1.containsKey(currWord.charAt(0))) {
                for (int j = 1; j < currWord.length(); j++) {
                    if (!row1.containsKey(currWord.charAt(j))) {
                        valid = false;
                        break;
                    }
                }
            }
            else if (row2.containsKey(currWord.charAt(0))) {
                for (int j = 1; j < currWord.length(); j++) {
                    if (!row2.containsKey(currWord.charAt(j))) {
                        valid = false;
                        break;
                    }
                }
            }
            else if (row3.containsKey(currWord.charAt(0))) {
                for (int j = 1; j < currWord.length(); j++) {
                    if (!row3.containsKey(currWord.charAt(j))) {
                        valid = false;
                        break;
                    }
                }
            }
            if (valid == true) {
                sol.add(words[i]);
            }
        }

        String[] solArray = new String[sol.size()];

        for (int i = 0; i < sol.size(); i++) {
            solArray[i] = sol.get(i);
        }

        return solArray;
    }
}