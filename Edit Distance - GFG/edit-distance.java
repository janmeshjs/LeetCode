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
        int[] prev = new int[t.length()+1];
        for(int j=0; j<=t.length(); j++)prev[j] = j;
        
        for(int i=1; i<=s.length(); i++){
            int[] curr = new int[t.length() + 1];
            curr[0] = i;
         for(int j=1; j<=t.length(); j++){
                
                if(s.charAt(i-1)==t.charAt(j-1)) 
                    curr[j] = prev[j-1];
                
                else curr[j]= 1+ Math.min(prev[j], Math.min(prev[j-1], curr[j-1]));
            }
            prev = curr;
        }
        return prev[t.length()];
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