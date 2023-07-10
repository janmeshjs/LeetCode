class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(triangle.size()-1).size();
        
        int[][] dp = new int[m][n];
        
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        
        return tri(0,0,triangle, dp);
    }
    
    public int tri(int m , int n, List<List<Integer>> triangle, int[][] dp){
        if(m==triangle.size()) return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        int sum = Math.min(tri(m+1, n, triangle,dp),tri(m+1, n+1, triangle, dp));
        
        return dp[m][n]=triangle.get(m).get(n) + sum;
    }
}