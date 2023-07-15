class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         Arrays.sort(nums);
        List<List<Integer>> outer=new ArrayList<>();
        outer.add(new ArrayList<>());
        int start=0;
        int end=0;
        for(int i=0;i<nums.length;i++)
        {    start=0;
            // if current and previous element is same,s=e+1;
            if(i >0 && nums[i]==nums[i -1])
            {
                start=end+1;
            }
            end=outer.size() - 1;
            int n=outer.size() ;
            for(int j=start;j<n;j++)
            {
        List<Integer> Internal=new ArrayList<>(outer.get(j));
                Internal.add(nums[i]);
                outer.add( Internal);
            }
        }
        return outer;
    }

}