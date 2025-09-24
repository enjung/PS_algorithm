import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long left = 0;
        long right = (long)times[times.length-1]*n;
        long mid = (left+right)/2;
        while(left<=right){
            mid = (left+right)/2;
            long people = 0; //int나누기 long이니까 long?
            for(int t : times){
                people += mid/t;
            }
            if(people>=n){
                answer = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
            
        
        return answer;
    }
}