/**
 * Hard problem but top 87%
 * Each number is a list, you want to decrease you either divide downwards or multiply upwards
 * (I divided down)
 */

class Day30 {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);    // need to convert it to a max heap
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                pq.offer(nums[i] * 2);
                min = Math.min(min, nums[i] * 2);
            }
            else {
                pq.offer(nums[i]);
                min = Math.min(min, nums[i]);
            }
        }
        
        int max = pq.peek();
        int dev = max - min;
        while (pq.size() > 0) {
            max = pq.poll();   
            dev = Math.min(max - min, dev);
            if (max % 2 == 0) {     
                pq.offer(max / 2);    
                min = Math.min(max / 2, min);
            }
            else {
                return dev;
            }
        }
        
        return dev;
    }
}