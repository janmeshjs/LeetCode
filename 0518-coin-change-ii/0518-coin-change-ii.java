class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        // for(int[] arr: dp){
        //     Arrays.fill(arr, -1);
        // }
        int[] prev = new int[amount+1];
        
        for(int i =0; i<=amount; i++){
            if(i%coins[0]==0)
            prev[i]= 1;
        }
        for(int i=1; i<coins.length; i++){
            int[] curr = new int[amount+1];
            for(int j = 0; j<=amount; j++){
                    int notake = prev[j];
                    int take =0;
                    if(coins[i]<=j){
                        take = curr[j-coins[i]];
                    }
                curr[j]= take + notake;
            }
            prev = curr;
        }
       
        return prev[amount];
    }
    
    public int coi(int ind, int amount, int[] coins, int[][] dp){
        if(ind ==0){
            if(amount%coins[0]==0) return 1;
            else return 0;
        }
        //if(amount==0) return 1;
        if(dp[ind][amount]!=-1) return dp[ind][amount];
        int notake = coi(ind-1, amount, coins, dp);
        int take =0;
        if(coins[ind]<=amount){
            take = coi(ind, amount-coins[ind], coins, dp);
        }
        
        return dp[ind][amount] = take+notake;
    }
}