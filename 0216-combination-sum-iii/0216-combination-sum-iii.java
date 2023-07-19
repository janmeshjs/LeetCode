class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
       List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        find(ans, list, k, n ,1);
        return ans;
    }
    
    public static void find(List<List<Integer>> result, List<Integer>       list, int k, int n, int start) {
        if(k == 1 && start <= n && n <= 9) {
            list.add(n);
            result.add(new ArrayList<>(list));
            list.remove(Integer.valueOf(n));
            return;
        }
        for(int i = start; i <= 9; i++) {
            if(i <= n && n - i > i) {
                list.add(i);
                find(result, list, k - 1, n - i, i + 1);
                list.remove(Integer.valueOf(i));
            }
            else break;
        }
    }
}