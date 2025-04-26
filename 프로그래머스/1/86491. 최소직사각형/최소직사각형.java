import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        //긴 쪽을 가로, 짧은 쪽을 세로로 고정
        int maxw = Math.max(sizes[0][0], sizes[0][1]);
        int maxh = Math.min(sizes[0][0], sizes[0][1]);

        for (int i = 1; i < sizes.length; i++) {
            int w = Math.max(sizes[i][0], sizes[i][1]);
            int h = Math.min(sizes[i][0], sizes[i][1]);

            //가로가 들어가는 경우
            if (maxw >= w) {
                if (maxh >= h) continue;
                //세로만 안 들어간다면, 세로만 늘려주면 됨
                else maxh = h;
            }
            
            //가로가 안 들어가는 경우,
            else {
                //세로만 잘 들어간다면, 가로만 늘려주면 됨
                if (maxh >= h) maxw = w;
                //둘 다 안 들어간다면, 다 늘려줌
                else {
                    maxw = w;
                    maxh = h;
                }
            }
        }
        return maxw * maxh;
    }
}