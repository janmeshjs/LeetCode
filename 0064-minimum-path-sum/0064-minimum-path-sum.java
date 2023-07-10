class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return find(grid.length-1,grid[0].length-1,grid, dp);
    }
    public int find(int m , int n, int[][] grid, int[][] dp){
        if(m==0 && n ==0) dp[m][n]=grid[m][n];
        if(m<0 || n<0) return Integer.MAX_VALUE;;
        if(dp[m][n]!=-1) return dp[m][n];
        return dp[m][n]= Math.min(find(m-1, n, grid, dp), find(m, n-1, grid, dp))+ grid[m][n];
    }
}