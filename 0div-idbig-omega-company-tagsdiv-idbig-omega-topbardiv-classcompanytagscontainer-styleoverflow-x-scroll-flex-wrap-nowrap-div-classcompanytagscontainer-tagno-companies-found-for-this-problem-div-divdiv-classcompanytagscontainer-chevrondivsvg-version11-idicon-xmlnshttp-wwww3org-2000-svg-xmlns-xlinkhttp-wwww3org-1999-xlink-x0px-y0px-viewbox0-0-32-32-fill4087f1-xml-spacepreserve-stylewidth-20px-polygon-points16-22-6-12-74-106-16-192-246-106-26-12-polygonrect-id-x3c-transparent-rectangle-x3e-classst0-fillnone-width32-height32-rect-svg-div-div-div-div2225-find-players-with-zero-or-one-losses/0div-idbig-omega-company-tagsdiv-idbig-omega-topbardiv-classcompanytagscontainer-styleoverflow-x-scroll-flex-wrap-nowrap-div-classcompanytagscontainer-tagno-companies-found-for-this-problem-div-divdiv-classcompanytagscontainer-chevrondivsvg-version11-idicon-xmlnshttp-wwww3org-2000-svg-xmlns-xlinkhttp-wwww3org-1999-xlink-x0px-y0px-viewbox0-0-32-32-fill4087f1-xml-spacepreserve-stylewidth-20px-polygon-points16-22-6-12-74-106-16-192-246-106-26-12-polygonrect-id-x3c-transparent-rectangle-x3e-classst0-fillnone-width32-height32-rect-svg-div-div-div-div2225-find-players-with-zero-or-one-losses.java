class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] winner = new int[100001];
        int[] loser = new int[100001];

        for(int[] x: matches){
            winner[x[0]]++;
            loser[x[1]]++;
        }
        
        List<Integer> winAll = new ArrayList<>();
        List<Integer> loseOne = new ArrayList<>();
        
        for(int i=1; i<=100000; i++){
            if(winner[i]>0 && loser[i]==0)
                winAll.add(i);
            else if(loser[i]==1) loseOne.add(i);
        }
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        res.add(winAll);
        res.add(loseOne);

        return res;
        
    
    }
}