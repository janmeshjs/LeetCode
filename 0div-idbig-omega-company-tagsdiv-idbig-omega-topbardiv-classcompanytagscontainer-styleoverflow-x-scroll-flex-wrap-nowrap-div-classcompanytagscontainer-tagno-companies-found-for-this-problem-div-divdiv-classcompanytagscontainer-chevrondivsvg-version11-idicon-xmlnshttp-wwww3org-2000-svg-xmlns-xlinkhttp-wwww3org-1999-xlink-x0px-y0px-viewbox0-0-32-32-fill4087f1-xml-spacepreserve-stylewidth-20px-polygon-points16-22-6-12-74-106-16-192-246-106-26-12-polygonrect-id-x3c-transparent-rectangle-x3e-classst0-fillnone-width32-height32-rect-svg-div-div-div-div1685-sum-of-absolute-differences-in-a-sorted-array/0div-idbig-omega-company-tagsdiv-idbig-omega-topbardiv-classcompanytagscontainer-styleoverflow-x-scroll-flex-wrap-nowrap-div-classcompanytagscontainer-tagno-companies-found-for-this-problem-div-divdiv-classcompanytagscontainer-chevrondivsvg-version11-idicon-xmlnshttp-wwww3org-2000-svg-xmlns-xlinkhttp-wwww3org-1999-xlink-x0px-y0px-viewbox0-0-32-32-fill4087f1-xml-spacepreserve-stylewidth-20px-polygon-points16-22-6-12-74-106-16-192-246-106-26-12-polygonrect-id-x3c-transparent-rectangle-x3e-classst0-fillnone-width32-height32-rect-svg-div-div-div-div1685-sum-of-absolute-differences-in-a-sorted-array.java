class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] result = new int[nums.length];
        
        int totalSum =Arrays.stream(nums).sum();
        int leftSum=0;
        for(int i=0;i<nums.length;i++){
            int totaloccurence = nums[i]*(nums.length);
            int rightSum = totalSum-leftSum;
            int rightOccurence = (nums.length-i)*nums[i];
            int leftOccurence = totaloccurence-rightOccurence;
            int res= rightSum-rightOccurence+leftOccurence-leftSum;
            result[i]=res;
            leftSum+=nums[i];
        }
        return result;
    }
}