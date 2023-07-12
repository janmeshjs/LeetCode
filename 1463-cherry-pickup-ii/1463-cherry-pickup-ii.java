class Solution {
    public int cherryPickup(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][][] dp= new int[r][c][c];
        
        // for(int[][] arr: dp){
        //     for(int[] tem: arr){
        //         Arrays.fill(tem, -1);
        //     }
        // }
        
        for(int j1 = 0; j1<c; j1++){
            for(int j2 = 0; j2<c; j2++){
                if(j1==j2) dp[r-1][j1][j2]= grid[r-1][j1];
                else dp[r-1][j1][j2]= grid[r-1][j1]+ grid[r-1][j2];
            }
        }
        
        for(int i =r-2; i>=0; i--){
            for(int j1 =0; j1<c; j1++){
                for(int j2 =0; j2<c; j2++){
                    
                    int maxi = -100000000;
                    for(int dj1 = -1; dj1<=1; dj1++){
                        for(int dj2 = -1; dj2<=1; dj2++){
                             int value =0;
                            if(j1==j2) value = grid[i][j1];
                            else value = grid[i][j1]+grid[i][j2];
                            if(j1+dj1>=0 && j1+dj1<c && j2+dj2>=0 && j2+dj2<c)
                                value+= dp[i+1][j1+dj1][j2+dj2];
                            else 
                                value+= -100000000;
                            maxi = Math.max(maxi, value);  
                                }
                            }
                    dp[i][j1][j2]=maxi;
                         }
                }
            }
        
        
        
        return dp[0][0][c-1];
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