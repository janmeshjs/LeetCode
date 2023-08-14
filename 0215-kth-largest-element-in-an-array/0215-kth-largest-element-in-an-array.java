class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int x: nums){
            pq.add(x);
        }
        int ans =0;
        while(k-->0){
            ans = pq.poll();
        }
        return ans;
    }
}