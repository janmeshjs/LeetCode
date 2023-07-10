class Solution {
    public int uniquePaths(int m, int n) {
//        int[][] dp =new int[m][n];
//         for(int[] arr: dp){
//             Arrays.fill(arr, -1);
//         }
//         return help(m-1, n-1, dp);
//     }
    
//     public int help(int m, int n, int[][] dp){
//          if(m==0 && n==0) dp[m][n]=1;
//         if(m<0 || n<0) return 0;
        
//         if(dp[m][n]!=-1) return dp[m][n];
     
//         return dp[m][n]= help(m-1,n, dp) + help(m,n-1, dp);
//     }
        
        // Tabulation
        
     int[][] dp = new int[m][n];
        dp[0][0]= 1;
        for(int i = 0; i<m; i++){
            for(int j =0; j<n; j++){
                if(i==0 && j==0) dp[i][j]=1;
                else{
                    int up=0, dow=0;
                if(i>0) up =dp[i-1][j];
                if(j>0) dow= dp[i][j-1];
                
                dp[i][j]= up+dow;
                }
            }
        }
        
        return dp[m-1][n-1];
        
    }
}