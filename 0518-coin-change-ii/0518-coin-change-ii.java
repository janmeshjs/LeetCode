class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        for(int i =0; i<=amount; i++){
            if(i%coins[0]==0) dp[0][i] = 1;
            else dp[0][i]=0;
        }
        
        for(int i=1; i<coins.length; i++){
            for(int j = 0; j<=amount; j++){
                int notake = dp[i -1][j];
                int take =0;
                if(coins[i]<=j){
                    take = dp[i][j-coins[i]];
                }

                 dp[i][j] = take + notake;
            }
        }
        
        return dp[coins.length-1][amount];
    }
    public int f(int ind, int amount, int[] coins, int[][] dp){
        if(ind==0){
            if(amount%coins[0]==0)return 1;
             else return 0;
        }
        if(dp[ind][amount]!=-1) return dp[ind][amount];
        int notake = f(ind -1, amount, coins, dp);
        int take =0;
        if(coins[ind]<=amount){
            take = f(ind, amount-coins[ind], coins, dp);
        }
        
        return dp[ind][amount] = take + notake;
    }
}



