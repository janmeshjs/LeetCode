class Solution {
    public String customSortString(String order, String s) {
        char[] set = new char[26];
        for(char ch: s.toCharArray()){
            set[ch-'a']++;
        }
        String res="";
        for(char ch: order.toCharArray()){
            while(set[ch-'a']>0){
                res+=ch;
                set[ch-'a']--;
            }
        }
        
        for(int i =0; i<set.length; i++){
            while(set[i]>0){
                res+= (char)(i+'a');
                set[i]--;
            }
        }
        
        return res;
    }
}