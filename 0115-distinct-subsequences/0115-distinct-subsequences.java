class Solution {
    public int numDistinct(String s, String t) {
        
        int[] prev = new int[t.length()+1];
        prev[0]=1;
        
        for(int i =1; i<=s.length(); i++){
            for(int j =t.length(); j>=1; j--){
                if(s.charAt(i-1)==t.charAt(j-1)){
                     prev[j] = prev[j-1] + prev[j];
                }
            }
        }
        return prev[t.length()];
    }
    
    public int f(int i, int j, String s, String t, int[][] dp){
        if(j==0) return 1;
        if(i==0) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i-1)==t.charAt(j-1)){
            return dp[i][j] = f(i-1, j-1, s, t, dp) + f(i-1, j, s, t, dp);
        }
        else 
            return dp[i][j] = f(i-1,j, s, t, dp);
    }
}