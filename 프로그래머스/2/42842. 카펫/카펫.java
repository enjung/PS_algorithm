import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int w=yellow+2; w>=Math.sqrt(yellow)+2 ;w--){
            if(yellow%(w-2)==0){
                int h = yellow/(w-2) + 2;
                if(2*(w+h)==brown+4) {
                    answer[0]=w;
                    answer[1]=h;
                    break;
                }
            }
        }
        return answer;
    }
}