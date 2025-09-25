import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxW = 0;
        int maxH = 0;
        for(int[] s : sizes){
            int w = Math.max(s[0],s[1]); //긴 변
            int h = Math.min(s[0],s[1]); //짧은 변
            if(maxW<w) maxW=w;
            if(maxH<h) maxH=h;
        }
        return maxW*maxH;
    }
}