/*
 * Can Make Arithmetic Progression From Sequence
 *
 * Top 72% (2ms)
 * 
 * Putting comments for the gigabrain 0ms time solution.
 *      1) find the expected difference by (max val - min val / array size)
 *      2) See if every element fits in on that progression
 * 
 * */

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);

        int diff = arr[1] - arr[0];

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }

        return true;
    }
}

/*
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {

        int n = arr.length;

        int minNumber = Integer.MAX_VALUE;
        int maxNumber = Integer.MIN_VALUE;

        for (int num : arr)
        {
            if (minNumber > num)
                minNumber  = num;
            if (maxNumber < num)
                maxNumber = num;
        }

        if ((maxNumber - minNumber) % (n - 1) != 0)
            return false;

        int difference = (maxNumber - minNumber) / (n - 1);

        int i = 0;

        while (i < n)
        {
            if (arr[i] == minNumber + difference * i)
                i++;
            else if ((arr[i] - minNumber) % difference != 0)
                return false;
            else
            {
                int pos = (arr[i] - minNumber) / difference;

                if (pos < i || arr[pos] == arr[i])
                    return false;

                int tmp = arr[pos];
                arr[pos] = arr[i];
                arr[i] = tmp;
            }
        }

        return true;
    }
}
 */