import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int cnt = 0;
        int n = priorities.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int priority:priorities){
            queue.add(priority);
        }
        
        
        while(!queue.isEmpty()){
            for(int i=0;i<n;i++){
                if(queue.peek()==priorities[i]){
                 queue.remove();
                  cnt++;
                  if(i==location){
                        return cnt;
                  }
                } 
            }
        }
        
        return cnt;
    }   
}


