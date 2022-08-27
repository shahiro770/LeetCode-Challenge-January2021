/**
 * May 2021 Day 13
 * 
 * Literally bottom tier cause i'm using the leetcode solution after one edge case
 * broke my solution with 400 working test cases
 * 
 * You take each string, split it in all possible halves for the "," seperation, 
 * then split those halves again for the "." seperation in the coordinates.
 * 
 * The annoyance of the "0" is why this question is medium tier. You can't have a 
 * coordinate like (00, 01) cause leading 0s are redundant, buat at the same time need 
 * to be able to recognize something like 00011 as possibly being (0, 0.011)
 * 
 * I don't even want to think about this algorithm's time complexity
 * 
 */



class Solution { //aw
    public List<String> ambiguousCoordinates(String S) {
        List<String> ans = new ArrayList();
        for (int i = 2; i < S.length()-1; ++i)
            for (String left: make(S, 1, i))
                for (String right: make(S, i, S.length()-1))
                    ans.add("(" + left + ", " + right + ")");
        return ans;
    }

    public List<String> make(String S, int i, int j) {
        // Make on S.substring(i, j)
        List<String> ans = new ArrayList();
        for (int d = 1; d <= j-i; ++d) {
            String left = S.substring(i, i+d);
            String right = S.substring(i+d, j);
            if ((!left.startsWith("0") || left.equals("0"))
                    && !right.endsWith("0"))
                ans.add(left + (d < j-i ? "." : "") + right);
        }
        return ans;
    }
}
