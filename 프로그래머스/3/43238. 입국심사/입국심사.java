import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long left = 0;
        long right = (long)times[times.length-1]*n; //long??
        //long mid = (long)(left+right)/2; // long???
        while(left<=right){
            long mid = (left+right)/2; 
            long people = 0;
            for(int t : times){
                people+= mid/t;
            }
            if(people>=n){
                answer = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }   
            
        }
        //System.out.print()
        return answer;
        
    }
}
