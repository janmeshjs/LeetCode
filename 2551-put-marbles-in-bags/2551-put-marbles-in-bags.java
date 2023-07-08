class Solution {
    public long putMarbles(int[] weights, int k) {
        int[] pairweights = new int[weights.length-1];
        for(int i =0; i<weights.length-1; i++){
            pairweights[i]= weights[i]+weights[i+1];
        }
        
        Arrays.sort(pairweights, 0, weights.length-1);
        long ans = 0;
        for (int i = 0; i < k - 1; ++i) {
            ans += pairweights[weights.length - 2 - i] - pairweights[i];
        }

        return ans;

    }
}