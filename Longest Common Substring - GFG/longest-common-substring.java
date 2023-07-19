//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
        int[][] dp = new int[S1.length()+1][S2.length()+1];
        
        for(int i =0;i<=n; i++) dp[i][0]= 0;
        for(int i =0; i<=m; i++) dp[0][i] = 0;
        int res=0;
        for(int i =1; i<=n; i++){
            for(int j =1; j<=m ; j++){
                if(S1.charAt(i-1)==S2.charAt(j-1)){
                    dp[i][j]=1+ dp[i-1][j-1];
                    res = Math.max(res, dp[i][j]);
                } 
                else dp[i][j]=0; 
            }
        }
        
        return res;
    }
}