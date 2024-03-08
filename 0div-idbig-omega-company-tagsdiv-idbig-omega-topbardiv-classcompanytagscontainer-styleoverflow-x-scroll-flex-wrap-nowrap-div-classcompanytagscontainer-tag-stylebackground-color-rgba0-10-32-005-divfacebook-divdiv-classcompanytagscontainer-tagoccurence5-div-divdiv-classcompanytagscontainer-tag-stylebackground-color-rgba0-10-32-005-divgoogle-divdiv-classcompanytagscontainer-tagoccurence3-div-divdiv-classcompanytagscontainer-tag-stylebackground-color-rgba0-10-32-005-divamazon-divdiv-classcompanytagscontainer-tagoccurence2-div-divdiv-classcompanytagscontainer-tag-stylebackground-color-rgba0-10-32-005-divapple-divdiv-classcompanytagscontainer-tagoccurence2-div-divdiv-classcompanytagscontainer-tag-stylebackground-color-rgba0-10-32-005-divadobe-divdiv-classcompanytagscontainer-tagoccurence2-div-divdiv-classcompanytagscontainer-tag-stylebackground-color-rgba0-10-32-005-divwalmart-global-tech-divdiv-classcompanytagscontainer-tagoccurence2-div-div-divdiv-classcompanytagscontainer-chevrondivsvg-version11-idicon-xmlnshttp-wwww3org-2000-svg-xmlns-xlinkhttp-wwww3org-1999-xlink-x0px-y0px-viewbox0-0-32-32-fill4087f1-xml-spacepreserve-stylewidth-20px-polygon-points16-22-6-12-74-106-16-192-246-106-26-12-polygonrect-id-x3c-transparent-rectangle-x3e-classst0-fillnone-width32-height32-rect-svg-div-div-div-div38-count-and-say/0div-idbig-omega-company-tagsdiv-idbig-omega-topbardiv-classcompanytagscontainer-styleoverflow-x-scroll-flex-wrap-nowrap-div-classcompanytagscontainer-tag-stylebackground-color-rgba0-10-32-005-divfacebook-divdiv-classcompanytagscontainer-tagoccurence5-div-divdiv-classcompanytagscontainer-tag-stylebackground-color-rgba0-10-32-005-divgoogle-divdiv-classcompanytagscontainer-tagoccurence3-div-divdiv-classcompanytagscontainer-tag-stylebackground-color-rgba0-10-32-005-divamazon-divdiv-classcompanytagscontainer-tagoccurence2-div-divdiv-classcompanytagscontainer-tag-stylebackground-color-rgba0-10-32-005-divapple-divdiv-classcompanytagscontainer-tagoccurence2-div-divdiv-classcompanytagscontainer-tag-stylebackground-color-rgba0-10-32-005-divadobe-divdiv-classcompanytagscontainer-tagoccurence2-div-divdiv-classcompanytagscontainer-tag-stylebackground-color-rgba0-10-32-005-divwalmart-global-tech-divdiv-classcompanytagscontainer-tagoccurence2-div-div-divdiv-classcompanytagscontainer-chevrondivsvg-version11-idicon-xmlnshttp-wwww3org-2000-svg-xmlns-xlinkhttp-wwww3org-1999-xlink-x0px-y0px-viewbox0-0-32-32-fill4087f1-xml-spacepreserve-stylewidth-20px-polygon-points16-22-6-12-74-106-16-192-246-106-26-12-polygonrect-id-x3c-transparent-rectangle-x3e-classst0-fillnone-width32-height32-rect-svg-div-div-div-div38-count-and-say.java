class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        if(n==2) return "11";
        String res = "";
        
        for(int i =2;i<n; i++){
            if(i==2)res="11";
            String newres ="";
            
            int count =1;
            for(int j =1; j<res.length();j++){
                if(res.charAt(j)==res.charAt(j-1)){
                    count++;
                }
                else{
                    newres=newres+count+res.charAt(j-1);
                    count =1; 
                }

            }
            newres=newres+count+res.charAt(res.length()-1);
            res = newres;
            

        //System.out.println(newres);
        }
        
        return res;
    }
}
