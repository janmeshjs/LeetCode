class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int x: nums){
            sum+=x;
        }
        if(sum%2!=0) return false;
        int n = nums.length;
        int k = sum/2;
        Boolean[][] dp= new Boolean[nums.length][k+1];
        for(Boolean[] x: dp){
            Arrays.fill(x,false);
        }
        for(int i =0; i<n; i++){
            dp[i][0] = true;
        }
        if(nums[0]<=k) dp[0][nums[0]]= true;
        
        for(int i =1; i<n; i++){
            for(int j =1; j<=sum/2; j++){
                 boolean ntake= dp[i-1][j];
                    boolean take = false;
                    if(j-nums[i]>=0){
                        take = dp[i-1][j-nums[i]];
                    }
                    dp[i][j]= take | ntake;
            }
        }
        
        return dp[n-1][k];
        
        
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