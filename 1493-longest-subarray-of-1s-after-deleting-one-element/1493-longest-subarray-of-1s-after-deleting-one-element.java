class Solution {
    public int longestSubarray(int[] nums) {
        int i =0; int j = 0; int flag = 0;
    int count =0; int countzer=0; int max = Integer.MIN_VALUE;
        while(i<nums.length && j<nums.length){
            if(nums[j]==0 && countzer==1){
                i++;
                j=i;
                count=0;
                countzer=0;
            }
            if(nums[j]==1) {
                count++;
                flag++;
            }
            else if(nums[j]==0) countzer++;
            max = Math.max(count+countzer,max);
            j++;
        }
        if(flag==0) return 0;
        return max-1;
    }
}