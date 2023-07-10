class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev2=0, prev =nums[0];
        for(int i =1; i<n; i++){
            int pick = nums[i];
            if(i>1) pick+= prev2;
            int notpick = 0+prev;
            int curr= Math.max(pick, notpick);
            prev2=prev;
            prev = curr;
        }
        return prev;
    }
}