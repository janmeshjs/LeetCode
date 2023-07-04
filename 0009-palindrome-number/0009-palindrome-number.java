class Solution {
    public boolean isPalindrome(int x) {
        
        long temp =x;
        long rev = 0;
        
        while(temp>0){
            long rem =temp%10;
            rev = rev*10+rem;
            temp/=10;
                
        }
        //rev+=temp;
        System.out.println(rev);
        if(rev==x) return true;
        else return false;
    }
}