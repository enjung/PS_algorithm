import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        int cnt = 0;
        Arrays.sort(citations);
        
        for(int i=n-1;i>=0;i--){
            if(cnt>=citations[i]) return cnt;
            cnt++;
        }
        return cnt;
    }
}