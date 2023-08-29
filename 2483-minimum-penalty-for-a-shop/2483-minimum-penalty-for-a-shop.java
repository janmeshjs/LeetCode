class Solution {
    public int bestClosingTime(String s) {
        int max = 0;
        int penalty=0, time=-1;
        
        for(int i =0; i<s.length(); i++){
            
            if(s.charAt(i)=='Y') penalty+=1;
            else penalty-=1;
            
            if(penalty>max){
                time = i;
                max = penalty;
            }
        }
        return time+1;
    }
}
