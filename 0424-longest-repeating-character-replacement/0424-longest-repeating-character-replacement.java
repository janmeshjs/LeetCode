class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int left =0; int right = 0;
         int max =0; int res =0;
        while(left<s.length() && right<s.length()){
            arr[s.charAt(right)-'A']++;
            for(int x: arr) max = Math.max(max, x);
            if(((right-left+1) - max)<=k){
                res = Math.max(right- left +1, res);
                right++;
            }
            else {
            arr[s.charAt(left)-'A']--;
            left++;
                right++;
            }
            
        }
        return res;
    }
}