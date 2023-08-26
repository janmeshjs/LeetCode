class Solution {
    public int findLongestChain(int[][] pairs) {
    Arrays.sort(pairs, (a,b) -> Integer.compare(a[1], b[1]));
        
        int prev = Integer.MIN_VALUE;
        int res =0;
        for(int[] pair: pairs){
            if(prev<pair[0]){
                prev = pair[1];
                res++;
            }
        }
        return res;
    }
}