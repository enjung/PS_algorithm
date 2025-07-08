import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int w=3;w<=yellow+2;w++){
            if((brown+yellow)%w!=0) continue;
            int h= (brown+yellow)/w;
            if(w<h) continue;
            if(brown == 2*(w+h)-4){
                if(yellow==(w-2)*(h-2)){
                    answer[0]=w;
                    answer[1]=h;
                    break;
                }
            }
        }
        return answer;
    }
}