import java.util.*;

class Solution {
    public long solution(int[] diffs, int[] times, long limit) {
        long answer = 0;
        long left = 1;
        long right = 100000;
        long level = 1;
        
        while(left<=right){
            level = (left+right)/2;
            long time = cal(level,diffs,times,limit);
            
            //level을 더 높여야 함
            if(time>limit) {
                left = level+1;
            }
            //level을 낮춰야 함
            else{
                answer = level;
                right = level-1;
            }
        }
        return answer;
    }
    
    public long cal(long level,int[] diffs, int[] times, long limit){
            long cur=0;
            for(int i=0;i<diffs.length;i++){
                if(diffs[i]<=level){
                    cur=cur+times[i];
                    continue;
                }
                cur+=(diffs[i]-level)*(times[i]+times[i-1]) + times[i];
                if (cur > limit) return cur;
            }
            return cur;
        }
    
}
//이분탐색
//첫번째 문제를 못 푸는 경우는 없나?
//left=1이면 왜 index에러?