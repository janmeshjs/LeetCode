class Solution {
    public int minFallingPathSum(int[][] matrix) {
         int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
       int[] prev = new int[m]; 
        for(int i =0; i<m; i++){
            prev[i]= matrix[0][i];
        }
        
        for(int i=1; i<n; i++){
            int[] cur = new int[m];
            for(int j =0; j<m; j++){
                int min = Integer.MAX_VALUE;
                for(int k=0;k<m;k++){
                    if(k!=j)
                       min = Math.min(min,prev[k]);
                }
                cur[j] = min + matrix[i][j];
            }
            prev = cur;
        }
    int maxi = Integer.MAX_VALUE;
        for(int i =0; i<m; i++){
            maxi = Math.min(maxi, prev[i]);
        }
            
        return maxi;
    }
}