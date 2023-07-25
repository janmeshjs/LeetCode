class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
         int arr[]= new int[26];

        for(int i=0;i<magazine.length();i++)
            arr[magazine.charAt(i)-'a']++;

        for(char i :ransomNote.toCharArray()){
            arr[i-'a']--;

            if(arr[i-'a'] < 0)
                return false;
        }
        return true;
    }
}