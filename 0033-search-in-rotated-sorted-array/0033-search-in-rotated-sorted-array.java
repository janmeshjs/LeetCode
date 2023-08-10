class Solution {
    public int search(int[] nums, int target) {
        
      int left = 0; 
        int right = nums.length-1;

        while(left<right){
            if(nums[left]==target)
            break;
            else if(nums[right]==target)
            break;

            if(nums[left]-target<nums[right]-target)
            left++;
            else if(nums[right]-target<nums[left]-target)
            right--;
        }
        if(nums[left]==target)
        return left;
        else if(nums[right]== target)
        return right;
        else 
        return -1; 
    }
}