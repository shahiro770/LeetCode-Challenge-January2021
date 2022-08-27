/**
 * This solution was alright, but the proper optimization is to put it all in an array of length n
 * and then use String(arr[]) to merge it all at once (cause adding to a string slows)
 * Still 13 ms runtime
 */

class Day28 {


    public String getSmallestString(int n, int k) {
        String str = "";
        int remainder = k;
        int toAdd = 0;
        int length = 0;
        
        while (length != n ) {
            if (remainder > 26 && remainder - 26 >= n - length) {
                toAdd = 26;
            }
            else {
                toAdd = (remainder - (n - length - 1));
                if (toAdd == 1) {
                    str = "a".repeat(n - length) + str;
                    break;
                }
            }
            remainder -= toAdd;
            length++;
            str = (char)(toAdd + 'a' - 1) + str;
        }
        
        return str;
    }
}