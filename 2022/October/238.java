/**
 * Top K Frequent Elements 
 *
 * October 2022
 * Top 100% (1ms)  
 *
 * Get the prefixes and the postfixes at individual spots in the array.
 * Ans[i] = prefix[i - 1] * postfix[i + 1]
 * 
 * Time complexity: O(n) 
 * */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        prefix[0] = nums[0];
        postfix[postfix.length - 1] = nums[nums.length - 1];
        int[] ans = new int[nums.length];

        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }
        for (int i = postfix.length - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * nums[i];
        }

        ans[0] = postfix[1];
        ans[ans.length - 1] = prefix[nums.length - 2];
        for (int i = 1; i < ans.length - 1; i++) {
            ans[i] = prefix[i - 1] * postfix[i + 1];
        }

        return ans;
    }
}

/*
i:      0       1       2       3       

Pre:    [1,      2,      6,     24]
Post:   [24,    24,     12,     4]  
Ans             pre0    pre1    pre2
        post1   post2   post3     
*/