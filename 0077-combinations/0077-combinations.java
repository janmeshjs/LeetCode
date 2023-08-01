class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        fun(1, n, k, list);
        return res;
    }
    
    public void fun(int ind, int n, int k, List<Integer> list ){
        if(k==0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = ind;i<=n-k+1;i++){
            list.add(i);
            fun(i+1,n,k-1, list);
            list.remove(list.size()-1);
        }
    }
}