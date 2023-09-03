class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp= new int[m+1][n+1];
        for(int[] arr: dp) Arrays.fill(arr, -1);
        return uni(0,0,m,n, dp);
    }
    public int uni(int r, int c, int m, int n, int[][] dp){
        if(r>=m || c>=n)return 0;
        if(r==m-1 && c == n-1) return 1;
        if(dp[r][c]!=-1) return dp[r][c];
        int right = 0;
        int down =0;
        right = uni(r, c+1, m, n, dp);
        down = uni(r+1, c, m, n, dp);
        
        return dp[r][c]=right +down;
        
    }
}