class Solution {
    public boolean canCross(int[] stones) {
       Boolean [][] dp = new Boolean[stones.length+1][stones.length+1];
        
        return fun(0, 1, stones, dp);
    }
    public boolean fun(int i, int jump, int[] stones,Boolean [][] dp){
        if(i>=stones.length){
            return false;
        }
        if(i==stones.length-1){
            return true;
        }
        if(dp[i][jump]!=null){
            return dp[i][jump];
        }
        int next = stones[i]+jump;
        int index = Arrays.binarySearch(stones,next);
        if(index>i){
            boolean jump1 = fun(index,jump-1,stones,dp);
            boolean jump2 = fun(index,jump,stones,dp);
            boolean jump3 = fun(index,jump+1,stones,dp);
            return dp[i][jump] = jump1||jump2||jump3;
        }
        return false;
    }
}