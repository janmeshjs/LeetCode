class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][][] dp = new int[n][n][n][n];
        for(int[][][] x: dp){
            for(int[][] arr: x ){
                for(int[] arr2: arr){
                    Arrays.fill(arr2, -1);
                }
            }
        }
        
        return Math.max(0, cherry(grid, 0, 0, 0, 0, grid.length, dp));
    }
    int cherry(int[][] grid, int i1, int j1, int i2, int j2, int n, int[][][][] dp){
        if( i1>n-1 || i2>n-1 || j1>n-1 || j2>n-1 || grid[i1][j1]==-1 || grid[i2][j2]==-1) return Integer.MIN_VALUE;
        
          if(i1 == n - 1 && j1 == n - 1)
                return grid[i1][j1];

        if(i2 == n - 1 && j2 == n - 1)
            return grid[i2][j2];
        
        if(dp[i1][j1][i2][j2]!=-1) return dp[i1][j1][i2][j2];
        int cherries;
        if(i1==i2 && j1 == j2){
            cherries = grid[i1][j1];
        }else{
            cherries= grid[i1][j1]+grid[i2][j2];
        }
        
        cherries+= Math.max(Math.max(cherry(grid, i1+1, j1, i2+1, j2, n, dp ), cherry(grid, i1+1, j1, i2, j2+1, n, dp)),Math.max(cherry(grid, i1, j1+1, i2, j2+1, n, dp), cherry(grid, i1, j1+1, i2+1, j2, n, dp)));
        
        return dp[i1][j1][i2][j2] = cherries;
    }
}