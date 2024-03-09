class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i=0;
        int j =0; int res=-1;
         while(i<nums1.length &&j<nums2.length){
            if(nums1[i]<nums2[j]){
                i++;
            }
             else if(nums1[i]>nums2[j]){
                 j++;
             }
             else{
                 res = nums1[i];
                 break;
             }
        } 
        return res;
    }
}