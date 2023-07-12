class Solution {
    public int cherryPickup(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][][] dp= new int[r][c][c];
        
        for(int[][] arr: dp){
            for(int[] tem: arr){
                Arrays.fill(tem, -1);
            }
        }
        return f(0,0,grid[0].length-1, grid, dp);
    }
    
    int f(int i, int j1, int j2, int[][] a, int[][][]dp){
        int n= a.length;
        int m = a[0].length;
        if(j1<0 || j1>=m || j2<0 || j2>=m) return -100000000;
        
        if(i==n-1){
            if(j1==j2) return a[i][j1];
            else return a[i][j1]+a[i][j2];
        }
        
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        int maxi = 0;
        for(int dj1 = -1; dj1<=1; dj1++){
            for(int dj2 = -1; dj2<=1; dj2++){
                if(j1==j2){
                    maxi = Math.max(maxi, a[i][j1]+f(i+1, j1+dj1, j2+dj2, a, dp));
                    //dp[i][j1][j2] = maxi;
                }
                else 
                    maxi = Math.max(maxi, a[i][j1]+a[i][j2]+f(i+1, j1+dj1, j2+dj2, a, dp));
                    //dp[i][j1][j2] = maxi;
            }
        }
        
        return dp[i][j1][j2] = maxi;
    }
}