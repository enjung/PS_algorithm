import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i=1;i<=Math.sqrt(brown+yellow);i++){
            int h = i;
            int w = (brown+4)/2 - h;
            if(yellow == (h-2)*(w-2)){
                answer[0]=w;
                answer[1]=h;
                break;
            } 
        }
        
        return answer;
    }
}