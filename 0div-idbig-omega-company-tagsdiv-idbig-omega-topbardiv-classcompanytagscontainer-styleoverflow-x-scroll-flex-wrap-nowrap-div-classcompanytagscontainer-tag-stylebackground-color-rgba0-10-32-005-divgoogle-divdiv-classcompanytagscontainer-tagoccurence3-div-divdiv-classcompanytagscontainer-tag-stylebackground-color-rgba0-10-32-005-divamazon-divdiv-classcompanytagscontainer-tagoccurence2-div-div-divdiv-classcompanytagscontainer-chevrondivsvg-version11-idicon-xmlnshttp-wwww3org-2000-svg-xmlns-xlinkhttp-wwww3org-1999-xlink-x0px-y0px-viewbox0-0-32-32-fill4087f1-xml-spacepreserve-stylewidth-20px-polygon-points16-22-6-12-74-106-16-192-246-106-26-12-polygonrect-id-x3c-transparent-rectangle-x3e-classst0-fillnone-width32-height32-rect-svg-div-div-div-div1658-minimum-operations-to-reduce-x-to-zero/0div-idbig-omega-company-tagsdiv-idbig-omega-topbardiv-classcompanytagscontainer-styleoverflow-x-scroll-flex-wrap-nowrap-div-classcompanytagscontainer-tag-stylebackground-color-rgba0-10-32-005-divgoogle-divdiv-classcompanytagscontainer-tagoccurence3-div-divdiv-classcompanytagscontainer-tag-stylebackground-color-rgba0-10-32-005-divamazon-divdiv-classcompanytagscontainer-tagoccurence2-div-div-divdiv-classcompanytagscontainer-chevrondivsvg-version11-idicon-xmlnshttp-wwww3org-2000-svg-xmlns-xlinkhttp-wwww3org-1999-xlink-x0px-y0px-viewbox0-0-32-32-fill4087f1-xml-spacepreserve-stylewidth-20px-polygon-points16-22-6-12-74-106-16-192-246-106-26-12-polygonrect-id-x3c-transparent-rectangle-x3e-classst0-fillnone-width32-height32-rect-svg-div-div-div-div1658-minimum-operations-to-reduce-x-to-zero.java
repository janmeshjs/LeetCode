class Solution {
    public int minOperations(int[] nums, int x) {
       int n = nums.length;
        int targetSum = 0;
        
        for (int num : nums) {
            targetSum += num;
        }
        
        int windowSum = targetSum - x;
        
        if (windowSum < 0) {
            return -1; 
        }
        
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int currentSum = 0;
        
        for (int right = 0; right < n; right++) {
            currentSum += nums[right];
            
            while (currentSum > windowSum) {
                currentSum -= nums[left];
                left++;
            }
            
            if (currentSum == windowSum) {
                minLength = Math.min(minLength, n - (right - left + 1));
            }
        }
        
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}