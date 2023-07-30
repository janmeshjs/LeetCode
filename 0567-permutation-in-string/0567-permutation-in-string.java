class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr = new int[26];
        for(char ch: s1.toCharArray()){
            arr[ch-'a']++;
        }
        int left = 0; int right = s1.length()-1; boolean flag = true;
        while(right<s2.length()){
            int[] arr2 = new int[26];
        for(int i =left; i<=right;i++){
            arr2[s2.charAt(i)-'a']++;
        }
        
        for(int i =0; i<26; i++){
            if(arr[i]!=arr2[i]){
                right++;
                left++;
                flag = false;
                break;
            }else{
                flag = true;
            }
            }
                    System.out.println(left+" "+ right);
            if(flag) return true;
            
        }
        return false;
    }
}