import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n+1][m+1];
        //dp[1][1] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(i==1&&j==1){
                    dp[1][1]=1;
                    continue;
                }
                boolean isPuddle = false;
                for(int[] puddle : puddles){
                    if(j==puddle[0]&& i==puddle[1]){
                        isPuddle = true;
                        break;
                    }
                }
                int len = 0;
                if(isPuddle) {
                    dp[i][j]=0;
                    continue;
                }
                //오른쪽 이동
                if(j>1){
                    len += dp[i][j-1];
                }
                //아래로 이동
                if(i>1){
                    len += dp[i-1][j];
                }
                dp[i][j] = len%1000000007;
            }
        }
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=m;j++){
        //         System.out.print(dp[i][j]);
        //     }
        //     System.out.println("");
        // }
        return dp[n][m];
    }
}

