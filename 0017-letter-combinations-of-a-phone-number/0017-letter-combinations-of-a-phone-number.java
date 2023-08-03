class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.isEmpty()) return list;
        return help("", digits);
    }
    public List<String> help(String p, String up){
        if(up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = up.charAt(0)-'0';
        int ind = (digit-2)*3;
        int len = (digit-1)*3;
        
        if(digit == 8 || digit ==9 ){
            ind+=1;
            len+=1;
        }
        if(digit==7 || digit ==9){
            len+=1;
        }
    
        List<String> list = new ArrayList<>();        
        for(; ind<len; ind++){
            char ch = (char)(ind+'a');
            list.addAll(help(p+ch, up.substring(1)));
        }
        return list;
    }
}