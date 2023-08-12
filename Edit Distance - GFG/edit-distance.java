//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String s, String t) {
        // Code here
        int[][] dp = new int[s.length()+1][t.length()+1];

        for(int i=0; i<=s.length(); i++){
         for(int j=0; j<=t.length(); j++){
                if(i==0) dp[i][j] = j;
                else if(j==0) dp[i][j] = i;
                
                else if(s.charAt(i-1)==t.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                
                else dp[i][j]= 1+ Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
            }
        }
        return dp[s.length()][t.length()];
    }
    
    public int edit(int i, int j, String s, String t, int[][] dp) {
        
        if(i<0) return j+1;
        if(j<0) return i+1;
        
        if(s.charAt(i)==t.charAt(j)) return edit(i-1, j-1, s, t, dp);
        
        if(dp[i][j]!= -1) return dp[i][j];
        int insert = 1+ edit(i, j-1, s, t, dp);
        int delete = 1+ edit(i-1, j, s, t, dp);
        int replace = 1+ edit(i-1, j-1, s, t, dp);
        
        return dp[i][j]= Math.min(insert, Math.min(delete, replace));
        
    }
}