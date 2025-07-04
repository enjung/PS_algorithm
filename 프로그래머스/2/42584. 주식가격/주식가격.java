import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0;i<prices.length-1;i++){
            int cnt = 0;
            int cur = prices[i];
            for(int j=i+1;j<prices.length;j++){
                cnt++;
                if(prices[j]<cur) {
                    answer[i]=cnt;
                    break;
                }
            }
            answer[i]=cnt;
        }
        answer[prices.length-1]=0;
        return answer;
    }
}