class Solution {
    public int numDistinct(String s, String t) {
        int[][]dp = new int[s.length()][t.length()];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return f(s.length()-1, t.length()-1, s, t, dp);
    }
    
    public int f(int i, int j, String s, String t, int[][] dp){
        if(j<0) return 1;
        if(i<0) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j] = f(i-1, j-1, s, t, dp) + f(i-1, j, s, t, dp);
        }
        else 
            return dp[i][j] = f(i-1,j, s, t, dp);
    }
}