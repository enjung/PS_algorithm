import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int min1, min2,tmp = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        //  힙 저장
        for (int s : scoville) {
           minHeap.add(s);
        }
        
        while(minHeap.size()!=1){
            if(minHeap.isEmpty()){
                break;
            }
            if(minHeap.peek()>=K){
                return answer;
            }
            min1 = minHeap.poll();
            min2 = minHeap.poll();
            tmp = min1 + min2*2;
            minHeap.add(tmp);
            answer++;
        }
        
        if(minHeap.peek()<K){
            return -1;
        }
        else{
            return answer;
        }
        
    }
}