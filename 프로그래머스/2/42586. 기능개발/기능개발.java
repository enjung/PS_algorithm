import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        int size = progresses.length;
        List<Integer> res = new ArrayList<>();
        
        for(int i=0; i<size; i++){
            progresses[i]=100-progresses[i];
            q.add((int)Math.ceil((double)progresses[i]/speeds[i])); 
            //99/10일때 10을 얻으려면 (double)필수
        }
        
    
        
        int cur = q.remove();
        int cnt = 1;
        
        while(!q.isEmpty()){
            if(q.peek()<=cur){
            //  다음 값이 더 작다면?
                cnt++;
                q.remove();
                //cur은 원래 게 더 크므로 유지.
            }
            // 다음 값이 더 크다면?
            // 지금까지 cnt를 answer에 저장하고 새로 시작
            else{
            
                res.add(cnt);
                //i++;
                cnt=1;
                cur=q.remove();
            }
            
            
        }
        res.add(cnt);
        
        //List -> 배열
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }

        
        return answer;
    }
}