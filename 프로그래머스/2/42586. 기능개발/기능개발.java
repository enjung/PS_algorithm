import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        int[] days = new int[n];
        
        for(int i=0;i<n;i++){
            days[i] = (int)Math.ceil((double)(100-progresses[i])/speeds[i]);
        }
        
        List<Integer> result = new ArrayList<>();
        int tmp = days[0];
        int cnt = 1;
        for(int i=1;i<n;i++){
            if(days[i]<=tmp) cnt++;
            else{
                result.add(cnt);
                tmp=days[i];
                cnt=1;
            }
        }
        result.add(cnt);
        
        //List -> 배열 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}