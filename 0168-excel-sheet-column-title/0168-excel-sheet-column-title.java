class Solution {
    public String convertToTitle(int col) {
        String s="";
        while(col>0){
            col--;
            s= (char)('A'+ col%26) + s; 
            col/=26;
        }
        return s;
    }
}