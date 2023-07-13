class Solution {
    int ans=0;
    int total =0;
    public int findTargetSumWays(int[] nums, int target) {
        for(int arr : nums){
            total += arr;
        }
        int[][] dp = new int[nums.length][2 * total + 1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return find(0, target, nums, 0, dp);
    }
    public int find(int ind, int target, int[] nums, int sum, int[][] dp){
        if(ind == nums.length){
             if(sum == target) return 1;
            else return 0;
         }
        else{
            if(dp[ind][sum + total]!=-1) return dp[ind][sum + total];
        int plus = find(ind+1, target, nums, sum+ nums[ind], dp);
        int subtract = find(ind+1, target,nums, sum- nums[ind], dp);
            return dp[ind][sum + total] = plus + subtract;
        }

    }
}