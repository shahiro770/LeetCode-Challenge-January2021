/**
 * I have a brute force solution that passes (aka garbage) but its due to java optimizations
 * This is the smart way to do it that I found from the leetCode discussions.
 * Gonna keep it to review memoization when I understand it more.
 */

class Day27
 {
    static List<Integer> previous = new ArrayList<>();
    static {
        previous.add(0);
    }

    public int concatenatedBinary(int n) {
        if (previous.size() > n)
            return previous.get(n);
        final int MODULO = (int)1e9+7;
        long result = previous.get(previous.size()-1);
        // Number of bits needed to store current number
        int pow = 1;
        // Numbers smaller than this can be stored in pow bits
        int powval = 2;
        while (powval < previous.size()) {
            pow++;
            powval *= 2;
        }
        for (int i=previous.size(); i<=n; i++) {
            // Check if need to update amount to shift
            if (i >= powval) {
                pow++;
                powval *= 2;
            }
            // shift old result up and add current number.
            result = (result << pow) + i;
            // Reduce modulo 10^9+7
            if (result >= MODULO)
                result %= MODULO;
			// Add result to memo - this will be at end of array and so will be index i
            previous.add((int)result);
        }
        return (int)result;
    }
}