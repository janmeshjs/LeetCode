class Solution {
    public boolean increasingTriplet(int[] nums) {
        int max = Integer.MAX_VALUE; int maxi = Integer.MAX_VALUE;
        for(int i =0; i<nums.length; i++){
            if(nums[i]<=max){
                max = nums[i];
            }
            else if(nums[i]<=maxi){
                maxi = nums[i];
            }else return true;
        }
        return false;
    }
}


