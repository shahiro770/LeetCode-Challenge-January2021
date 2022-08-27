/*
 * Reduce Array Size to The Half
 * 
 * Top 95% (29ms)
 *
 * Get the frequencies of each number then go greedy. 
 *
 * Time complexity: O(n
*/

class Solution {
    public int minSetSize(int[] arr) {
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int count[] = new int [max + 1];
        
        for(int num: arr){
            count[num]++;
        }
        
        Arrays.sort(count);
        int setSize = 0;
        int arrLen = arr.length;
        
        for (int i = count.length - 1; i >= 0; i--) {
            arrLen -= count[i];
            setSize++;
            if (arrLen <= arr.length / 2) {
                break;
            }
        }
        
        return setSize;
    }
}