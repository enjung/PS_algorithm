import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[] dp = new int[triangle.length];
        dp[0] = triangle[0][0];
        
        for(int i=1; i<triangle.length;i++){
            for(int j=i;j>=0;j--){
              if(j==0) dp[j] = dp[j]+triangle[i][j];
              else if(j==i) dp[j] = dp[j-1]+triangle[i][j];
              else{
                  dp[j] = Math.max(dp[j-1], dp[j]) + triangle[i][j];
              }
            }  
        }
        
        int answer = dp[0];
        for(int i=1;i<dp.length;i++){
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }
}