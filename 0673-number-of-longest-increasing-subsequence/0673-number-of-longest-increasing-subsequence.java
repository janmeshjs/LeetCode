class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[nums.length];
        int[] ct = new int[nums.length];
        Arrays.fill(dp, 1); int maxi=1;
        Arrays.fill(ct, 1);
        for(int i =0; i<n; i++){
            for(int j =0; j<i; j++){
                if(nums[j]< nums[i] && 1+dp[j]>dp[i]){
                    dp[i] = 1+dp[j];
                    ct[i]=ct[j]; 
                }
                else if(nums[j]<nums[i] && 1+dp[j]==dp[i ]){
                    ct[i]+=ct[j];
                }
        }
            maxi = Math.max(dp[i], maxi);
        }
         int c=0;
        for(int i=0; i<n; i++){
            if(dp[i]==maxi) c+=ct[i];
        }
        return c;
    }
}