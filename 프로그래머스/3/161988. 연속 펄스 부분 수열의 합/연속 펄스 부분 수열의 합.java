import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        long cur1, cur2, max1, max2;
        
        cur1 = cur2 = 0;
        max1 = max2 = Long.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            long a = (i%2==0)?sequence[i]:-sequence[i];
            cur1 = Math.max(a, cur1+a); //이전 걸 다 버리고 현재위치에서부터 새로운 부분수열을 시작할 것인지, 이어서 할 것인지 선택
            cur2 = Math.max(-a, cur2-a);
            max1 = Math.max(max1, cur1);
            max2 = Math.max(max2, cur2);
        }
        return Math.max(max1,max2);
    }
}