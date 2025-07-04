import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int totalWeight = 0;
        int time = 0;
        Queue<Integer> q = new LinkedList<>();
        
        for(int truck : truck_weights){
            while(true){
                //다리가 비어있을 때
                if(q.isEmpty()){
                    q.add(truck);
                    totalWeight+=truck;
                    time++;
                    break;
                }
                //다리가 다 차있을 때
                else if(q.size()==bridge_length){
                    totalWeight -= q.remove();
                }
                //트럭 더 올릴 수 있으면 올리기
                else{
                    if(totalWeight+truck <= weight){
                        q.add(truck);
                        totalWeight += truck;
                        time++;
                        break;
                    }
                    else{
                        time++;
                        q.add(0);
                    }
                }
            }
        }
        return time+bridge_length;
    }
}