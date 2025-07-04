import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> result = new ArrayList<>();
        int pre = -1;
        for(int n : arr){
            if(n!=pre){
                result.add(n);
                pre=n;
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i]=result.get(i);
        }
        return answer;
    }
}