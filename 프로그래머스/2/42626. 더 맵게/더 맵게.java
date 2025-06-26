import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i : scoville){
            pq.add(i);
        }
        
        while(pq.size()>=2 && pq.peek()<K){
            pq.add(pq.poll()+ 2*pq.poll());
            cnt++;
        }
        if(pq.size()==1 && pq.peek()<K) return -1;
        return cnt;
    }
}