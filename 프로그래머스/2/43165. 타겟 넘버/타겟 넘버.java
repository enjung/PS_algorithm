import java.util.*;

class Solution {
    int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(0, numbers, target, 0);
        return cnt;
    }
    
    public void dfs(int idx, int[] numbers, int target, int sum){
        if(idx==numbers.length){
            if(sum==target) cnt++;
            return;
        }
        else{
            dfs(idx+1,numbers,target,sum+numbers[idx]);
            dfs(idx+1,numbers,target,sum-numbers[idx]);
        }
        
    }
    
}