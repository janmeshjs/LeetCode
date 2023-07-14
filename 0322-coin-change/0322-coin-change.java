class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        int ans = coi(coins.length-1, amount, coins, dp);
        if(ans>=1000000009) return -1;
        return ans;
    }
    
    public int coi(int ind, int amount, int[] coins, int[][] dp){
        if(ind ==0){
            if(amount%coins[0]==0) return amount/coins[0];
            else return 1000000009;
        }
        //if(amount==0) return 1;
        if(dp[ind][amount]!=-1) return dp[ind][amount];
        int notake = coi(ind-1, amount, coins, dp);
        int take =Integer.MAX_VALUE;
        if(coins[ind]<=amount){
            take = 1+ coi(ind, amount-coins[ind], coins, dp);
        }
        
        return dp[ind][amount] = Math.min(take, notake);
    }
}