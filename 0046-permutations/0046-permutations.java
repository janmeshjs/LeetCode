class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        fun(0, nums);
        return res;
    }
    public void fun(int ind, int[] nums){
        if(ind == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int num: nums) list.add(num);
            res.add(list);
            return;
        }
        
        for(int i =ind; i<nums.length; i++){
            swap(i, ind, nums);
            fun(ind+1, nums);
            swap(i, ind, nums);
        }
    }
    
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]= temp;
    }
    
}