import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        int idx = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ') {
                idx = 0;
                sb.append(s.charAt(i));
                continue;
            }
            if(idx%2==0) sb.append(Character.toUpperCase(s.charAt(i)));
            else sb.append(Character.toLowerCase(s.charAt(i)));
            
            idx++;
        }
        
        answer = sb.toString();
        return answer;
    }
}