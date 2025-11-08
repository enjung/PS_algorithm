import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        List<Integer> res = new ArrayList<>();
        int prev = arr[0];
        res.add(arr[0]);
        for(int a:arr){
            if(a!=prev) res.add(a);
            prev = a;
        }
        answer = new int[res.size()];
        for(int i=0;i<res.size();i++){
            answer[i]=res.get(i);
        }
        return answer;
    }
}