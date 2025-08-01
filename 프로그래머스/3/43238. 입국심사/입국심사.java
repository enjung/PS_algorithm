import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long left = 1;
        long right = (long)times[times.length-1] * n;
        while(left<=right){
            long totalPeople = 0;
            long mid = (left+right)/2;
            for(int time: times){
                totalPeople+= mid/time;
            }
            if(totalPeople>=n){ //mid보다 더 짧은 시간 내 심사할 수도 있음
                answer = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return answer;
    }
}