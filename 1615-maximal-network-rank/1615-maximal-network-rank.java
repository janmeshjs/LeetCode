class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] degree = new int[n];
        Set<String> set = new HashSet<>();
        
        for(int[] road : roads){
            degree[road[0]]++;
            degree[road[1]]++;
            set.add(road[0]+","+ road[1]);
            set.add(road[1]+","+ road[0]);
        }
        int ans =0;
        for(int i =0; i<n; i++){
            for(int j =i+1; j<n; j++){
                int rank = degree[i]+degree[j];
                if(set.contains(i+","+j))
                    rank--;
                ans = Math.max(rank, ans);
            }
            
        }
        
        return ans;
    }
}
