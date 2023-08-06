class Solution {
    public int findCircleNum(int[][] grid) {
        boolean visited[] = new boolean[grid.length];
        int c=0;
        for(int i =0; i<grid.length;i++){
            if(!visited[i]){
                dfs(i, grid, visited);
                c++;
            }
        }
        return c;
    }
    
    void dfs(int j, int[][] grid, boolean[] visited){
        visited[j]=true;
        
        for(int i =0; i<grid[j].length; i++){
            if(!visited[i] && grid[j][i]==1)dfs(i, grid, visited);
        }
    }
}
