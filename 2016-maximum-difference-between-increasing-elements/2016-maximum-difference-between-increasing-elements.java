class Solution {
    public int maximumDifference(int[] nums) {
        int max = Integer.MIN_VALUE; int ans = 0;
        for(int i =nums.length-1; i>=0; i--){
            if(nums[i]>max){
                max = nums[i];
            }
            ans = Math.max(ans, max-nums[i]);
        }
        if(ans ==0) return -1;
        return ans;
    }
}