class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        memo = new int[m+1][n+1];
    for (int i = 0; i <= m; i++) {
    Arrays.fill(memo[i], -1);
    }
        return lcs(text1,text2, m, n);
    }

    int memo[][];

    public int lcs(String s1, String s2, int m , int n){
        if(memo[m][n]!=-1) return memo[m][n];
        if(m ==0 || n==0) memo[m][n]=0;
        else{
            if(s1.charAt(m-1)==s2.charAt(n-1))
                memo[m][n]= 1+lcs(s1,s2,m-1,n-1);
            else{
                memo[m][n]= Math.max(lcs(s1,s2,m-1,n), lcs(s1,s2,m,n-1));
                }       
        } 
        return memo[m][n];
    }
}

