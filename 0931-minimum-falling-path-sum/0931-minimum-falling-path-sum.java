class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        // for(int[] arr: dp){
        //     Arrays.fill(arr, -1);
        // }
        for(int i =0; i<m; i++){
            // maxi = Math.min(mat(matrix.length-1, i, matrix,dp), maxi);
            dp[0][i]= matrix[0][i];
        }
        
        for(int i=1; i<n; i++){
            for(int j =0; j<m; j++){
                if(i==0) continue;
                else if(j==0){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j+1],dp[i-1][j]);
                }
                else if(j==n-1){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j-1],dp[i-1][j]);
                }
                else{
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j+1],Math.min(dp[i-1][j-1],dp[i-1][j]));
                }
            }
        }
    int maxi = Integer.MAX_VALUE;
        for(int i =0; i<m; i++){
            maxi = Math.min(maxi, dp[n-1][i]);
        }
            
        return maxi;
    }
    
    public int mat(int m,int n, int[][] matrix, int[][] dp){
        if(n<0 || m<0 || n>=matrix[0].length) return 1000000009;
        if(m==0 ) return matrix[0][n];
        if(dp[m][n]!=-1) return dp[m][n];
             int d= matrix[m][n] + mat(m-1,n, matrix,dp);
            int  dl=matrix[m][n] + mat(m-1,n-1, matrix,dp);
            int dr=matrix[m][n] + mat(m-1,n+1, matrix,dp); 
                
        return dp[m][n]=Math.min(d, Math.min(dl, dr));
        
    }
}
