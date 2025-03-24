import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i : arr){
            if(stack.isEmpty()){
                stack.push(i);
            }
            else{
                if(stack.peek() == i){
                    continue;
                }
                else{
                    stack.push(i);
                }
            }
        }
        
        //stack에서 pop한 순서대로 answer배열에는 뒤에서부터 저장
        int n = stack.size();
        int[] answer = new int [n];
        for(int i=n-1;i>=0;i--){
            answer[i]=stack.pop();
        }

        return answer;
    }
}