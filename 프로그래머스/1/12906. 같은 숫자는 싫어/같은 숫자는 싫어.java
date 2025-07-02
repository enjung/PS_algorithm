import java.util.*;

public class Solution {
    public int[] solution(int []arr) {

        Stack<Integer> st = new Stack<>();
        for(int i : arr){
            if(st.isEmpty() || st.peek()!=i){
                st.push(i);
            }
        }
        
        int n = st.size();
        int[] answer = new int[n];
        for(int i=n-1; i>=0;i--){
            answer[i]=st.pop();
        }

        return answer;
    }
}