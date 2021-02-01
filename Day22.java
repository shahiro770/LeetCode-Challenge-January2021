import java.util.Arrays;

class Day22 {
    public boolean closeStrings(String word1, String word2) {
        int[] letterCounts1 = new int[26];
        int[] letterCounts2 = new int[26];
        for (int i = 0 ; i < word1.length(); i++) {
            letterCounts1[(int)(word1.charAt(i)) - 97]++;
        }
        for (int j = 0 ; j < word2.length(); j++) {
            letterCounts2[(int)(word2.charAt(j)) - 97]++;
        }
        
        for (int i = 0; i < letterCounts1.length; i++) {
            if (letterCounts1[i] > 0 && letterCounts2[i] == 0) {
                return false;
            }
        }
        
        Arrays.sort(letterCounts1);
        Arrays.sort(letterCounts2);
        
        for (int i = 0; i < letterCounts1.length;i++) {
            if (letterCounts1[i] != letterCounts2[i]) {
                return false;
            }
        }
        
        return true;
    }
}