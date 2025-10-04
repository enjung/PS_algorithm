import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int left = 1;
        int right = 100000;
        while(left<=right){
            int level = (left+right)/2;
            long time = cal(diffs,times,level);
            if(time<=limit){
                //level을 더 낮춰도 가능성 있음
                answer = level;
                right = level-1;
            }
            else{
                //level을 높여야 함
                left = level+1;
            }
        }
        return answer;
    }
    public long cal(int[] diffs, int[] times, int level){
        long time = 0;
        for(int i=0;i<diffs.length;i++){
            if(diffs[i]<=level) time+=times[i];
            else{
                if(i==0) time+=(long)(diffs[i]-level)*times[i] + times[i];
                else{
                    time+=(long)(diffs[i]-level)*(times[i]+times[i-1])+times[i];
                }
            }
        }
        return time;
    }
    
}