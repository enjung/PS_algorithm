import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char left = '(';
        char right = ')';
        Stack<Character> stack = new Stack<>();
        
        if(s.charAt(0)==right){
            return false;
        }
        stack.push(s.charAt(0));
        
        //배열 사이즈는 length속성이지만, String은 메소드이므로 length()
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==left){
                stack.push(left);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                else if(stack.peek()==left){
                    stack.pop();
                }
                // else{
                //     return false;
                // }
            }
        }
        
        if(!stack.isEmpty()){
            answer = false;
        }

        return answer;
    }
}