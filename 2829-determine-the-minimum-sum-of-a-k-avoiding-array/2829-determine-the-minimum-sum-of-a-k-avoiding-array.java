class Solution {
    public int minimumSum(int n, int k) {
        HashSet<Integer> set = new HashSet<>();
        int sum =0;
        for(int i =1; set.size()<n; i++){
            if(!set.contains(k-i)){
                set.add(i);
                sum+=i;
            }
        }
        return sum;
    }
}