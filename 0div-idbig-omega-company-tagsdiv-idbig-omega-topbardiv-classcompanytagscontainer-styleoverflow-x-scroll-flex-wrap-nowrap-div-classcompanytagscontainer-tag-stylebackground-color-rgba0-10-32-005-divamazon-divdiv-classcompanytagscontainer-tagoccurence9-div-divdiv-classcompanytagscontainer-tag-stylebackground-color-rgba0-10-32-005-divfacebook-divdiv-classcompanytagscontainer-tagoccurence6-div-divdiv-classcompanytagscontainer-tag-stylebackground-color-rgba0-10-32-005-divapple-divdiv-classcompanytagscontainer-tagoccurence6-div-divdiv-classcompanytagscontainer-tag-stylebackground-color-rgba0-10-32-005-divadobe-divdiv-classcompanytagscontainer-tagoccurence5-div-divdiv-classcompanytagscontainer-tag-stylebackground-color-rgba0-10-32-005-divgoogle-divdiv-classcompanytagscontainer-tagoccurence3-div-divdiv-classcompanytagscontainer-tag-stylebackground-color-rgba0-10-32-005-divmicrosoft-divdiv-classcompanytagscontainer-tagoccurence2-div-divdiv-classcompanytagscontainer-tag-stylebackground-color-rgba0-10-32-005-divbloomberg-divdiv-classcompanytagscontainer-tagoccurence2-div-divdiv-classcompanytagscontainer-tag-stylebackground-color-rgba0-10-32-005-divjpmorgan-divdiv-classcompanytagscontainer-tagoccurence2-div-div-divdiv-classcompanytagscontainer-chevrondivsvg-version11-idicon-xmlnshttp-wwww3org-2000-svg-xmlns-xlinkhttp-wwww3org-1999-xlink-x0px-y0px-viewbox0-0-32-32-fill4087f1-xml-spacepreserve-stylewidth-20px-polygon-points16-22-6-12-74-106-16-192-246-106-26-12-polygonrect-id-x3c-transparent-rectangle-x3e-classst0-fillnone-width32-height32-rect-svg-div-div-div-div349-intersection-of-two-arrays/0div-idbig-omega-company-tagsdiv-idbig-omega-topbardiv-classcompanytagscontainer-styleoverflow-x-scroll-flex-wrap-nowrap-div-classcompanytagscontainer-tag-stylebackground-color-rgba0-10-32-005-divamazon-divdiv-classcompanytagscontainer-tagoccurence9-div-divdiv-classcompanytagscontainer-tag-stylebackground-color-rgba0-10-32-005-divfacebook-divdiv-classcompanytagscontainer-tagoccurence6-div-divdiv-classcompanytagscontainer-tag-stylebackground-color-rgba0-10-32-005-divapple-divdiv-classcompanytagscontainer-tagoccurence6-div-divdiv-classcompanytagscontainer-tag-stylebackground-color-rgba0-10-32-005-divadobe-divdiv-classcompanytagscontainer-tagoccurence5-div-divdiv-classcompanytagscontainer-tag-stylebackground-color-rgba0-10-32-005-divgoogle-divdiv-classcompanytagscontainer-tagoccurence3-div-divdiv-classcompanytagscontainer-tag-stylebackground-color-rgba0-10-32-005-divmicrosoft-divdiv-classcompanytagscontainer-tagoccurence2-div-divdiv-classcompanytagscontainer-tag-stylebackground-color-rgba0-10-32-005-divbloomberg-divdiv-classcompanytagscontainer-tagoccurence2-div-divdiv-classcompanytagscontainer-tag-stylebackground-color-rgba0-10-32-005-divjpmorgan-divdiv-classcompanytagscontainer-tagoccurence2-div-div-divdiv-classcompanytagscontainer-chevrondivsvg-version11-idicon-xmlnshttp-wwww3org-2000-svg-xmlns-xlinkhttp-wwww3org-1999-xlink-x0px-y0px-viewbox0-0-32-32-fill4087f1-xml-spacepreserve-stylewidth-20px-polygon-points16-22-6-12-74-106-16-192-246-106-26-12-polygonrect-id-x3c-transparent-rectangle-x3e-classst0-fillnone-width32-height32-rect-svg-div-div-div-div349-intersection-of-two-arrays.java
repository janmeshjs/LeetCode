class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int a: nums1)set.add(a);
        Set<Integer> set2 = new HashSet<>();
        for(int b: nums2)set2.add(b);
        ArrayList<Integer> list = new ArrayList<>();
        for(int x: set){
            if(set2.contains(x))list.add(x);
        }
        int[] res = new int[list.size()];
        int i=0;
        for(int a:list){
            res[i++]=a;
        }
        return res;
        
    }
}