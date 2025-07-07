import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int maxw = 0;
        int maxh = 0;
        for(int[] s :sizes){
            int w = Math.max(s[0],s[1]);
            int h = Math.min(s[0],s[1]);
            maxw = Math.max(w,maxw);
            maxh = Math.max(h,maxh);
        }
        return maxw*maxh;
    }
}