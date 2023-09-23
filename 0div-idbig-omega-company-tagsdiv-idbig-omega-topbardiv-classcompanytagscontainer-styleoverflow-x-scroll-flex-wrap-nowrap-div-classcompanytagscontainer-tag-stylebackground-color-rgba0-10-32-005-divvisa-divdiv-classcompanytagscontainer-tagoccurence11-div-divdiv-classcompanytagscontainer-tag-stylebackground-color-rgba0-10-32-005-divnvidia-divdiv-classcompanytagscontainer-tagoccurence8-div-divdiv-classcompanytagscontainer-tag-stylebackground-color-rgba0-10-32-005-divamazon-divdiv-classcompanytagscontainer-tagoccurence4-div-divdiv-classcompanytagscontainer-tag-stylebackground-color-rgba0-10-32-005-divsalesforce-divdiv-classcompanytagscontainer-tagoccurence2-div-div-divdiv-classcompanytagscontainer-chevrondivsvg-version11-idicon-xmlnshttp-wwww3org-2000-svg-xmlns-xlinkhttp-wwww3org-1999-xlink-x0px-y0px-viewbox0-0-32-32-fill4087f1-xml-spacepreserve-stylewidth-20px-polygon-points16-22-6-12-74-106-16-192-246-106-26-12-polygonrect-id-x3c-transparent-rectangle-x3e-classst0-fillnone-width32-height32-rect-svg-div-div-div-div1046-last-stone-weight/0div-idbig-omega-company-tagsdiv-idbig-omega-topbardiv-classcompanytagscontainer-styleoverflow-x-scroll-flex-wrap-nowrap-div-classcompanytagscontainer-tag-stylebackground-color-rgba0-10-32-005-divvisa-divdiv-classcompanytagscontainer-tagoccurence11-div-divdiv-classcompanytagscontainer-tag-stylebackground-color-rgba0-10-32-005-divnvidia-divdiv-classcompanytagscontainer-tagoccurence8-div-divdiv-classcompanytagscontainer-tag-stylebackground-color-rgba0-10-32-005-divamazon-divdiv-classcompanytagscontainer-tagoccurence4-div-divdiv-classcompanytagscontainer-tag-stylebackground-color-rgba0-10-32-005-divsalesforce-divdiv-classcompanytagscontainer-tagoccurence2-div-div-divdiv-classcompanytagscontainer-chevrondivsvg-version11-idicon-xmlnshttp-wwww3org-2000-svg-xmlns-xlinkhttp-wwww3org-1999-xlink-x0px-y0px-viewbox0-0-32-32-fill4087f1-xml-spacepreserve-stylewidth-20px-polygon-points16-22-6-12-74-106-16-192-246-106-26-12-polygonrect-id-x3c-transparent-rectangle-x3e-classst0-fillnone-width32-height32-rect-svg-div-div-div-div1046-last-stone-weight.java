class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x: stones){
            pq.add(x);
        }
        int st=1;
        while(st>0 && pq.size()>1){
            int st1= pq.poll();
            int st2 = pq.poll();
            if(st1==st2) continue;
            else pq.add(st1-st2);
        }
        
        if(pq.size()==1) return pq.poll();
        else return 0;
    }
}