class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];
        
        for(int ind= nums.length-1; ind>=0; ind--){
            for(int prev = ind-1; prev >=-1; prev--){
                
                
                int take =0;
                if(prev == -1 || nums[ind]>nums[prev]) take = 1+dp[ind+1][ind+1];
                int notake = dp[ind+1][prev+1];

                dp[ind][prev+1] = Math.max(take,notake);
        
            }
        }
        
       return dp[0][0]; 
    }
    int f(int ind, int nums[], int prev, int[][] dp){
        if(ind ==nums.length){
            return 0;
        }
        if(prev != -1 && dp[prev][ind] != -1) return dp[prev][ind];
        int take =0;
        if(prev == -1 || nums[ind]>prev) take = 1+f(ind+1, nums, ind, dp);
        int notake = f(ind+1, nums, prev, dp);

        if(prev!= -1) return dp[prev][ind] = Math.max(take,notake);
        
        return Math.max(take,notake);
    }
}