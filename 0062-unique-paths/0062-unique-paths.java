class Solution {
    public int uniquePaths(int m, int n) {
       int[][] dp =new int[m][n];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return help(m-1, n-1, dp);
    }
    
    public int help(int m, int n, int[][] dp){
         if(m==0 && n==0) dp[m][n]=1;
        if(m<0 || n<0) return 0;
        
        if(dp[m][n]!=-1) return dp[m][n];
     
        return dp[m][n]= help(m-1,n, dp) + help(m,n-1, dp);
    }
}