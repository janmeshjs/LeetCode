class Solution {
    public int getMaximumGenerated(int n) {
        if(n==0) return 0;
        int[] dp = new int[n+1];
        int max = 1;
        dp[0]=0;
        dp[1]=1;
        for(int i =1; 2*i+1<=n ; i++){
            System.out.println(i);
            dp[i*2] =dp[i];
            dp[2*i+1] = dp[i]+dp[i+1];
            max = Math.max(max, Math.max(dp[i*2],dp[2*i+1]));
        }
     return max;       
    }
}