class Solution {
    public boolean validPartition(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        if(f(nums.length-1, nums, dp)==1) return true;
        else return false;
    }
    public int f(int ind, int[] nums, int[]dp){
        if(ind <0)
            return 1;
            
            int ans =0;
        if(dp[ind]!=-1) return dp[ind];
        if(ind-1>=0){
            if(nums[ind]==nums[ind-1]) ans = Math.max(ans, f(ind-2, nums, dp));
        }
        
        if(ind-2>=0){
            if(nums[ind]== nums[ind-1] && nums[ind-1]==nums[ind-2])
                ans = Math.max(ans, f(ind-3, nums, dp));
            else if(nums[ind]-nums[ind-1]==1 && nums[ind-1]-nums[ind-2]==1)
                ans = Math.max(ans, f(ind-3, nums, dp));
        }
        return dp[ind]=ans;
    }
}