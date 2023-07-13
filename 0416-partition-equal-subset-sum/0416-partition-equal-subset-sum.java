class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int x: nums){
            sum+=x;
        }
        if(sum%2!=0) return false;
        
        Boolean[][] dp= new Boolean[nums.length][sum/2+1];
        for(Boolean[] x: dp){
            Arrays.fill(x,null);
        }
        return part(nums.length-1, sum/2, nums, dp);
        
        
    }
    public boolean part(int ind, int k, int[] nums, Boolean[][] dp){
        if(k==0) return true;
        if(ind == 0) return nums[0] == k;
        
        if(dp[ind][k]!=null) return dp[ind][k];
        boolean ntake= part(ind-1, k, nums, dp);
        boolean take = false;
        if(nums[ind]<=k){
            take = part(ind-1, k-nums[ind], nums, dp);
        }
        return dp[ind][k]= take | ntake;
        
    }
}