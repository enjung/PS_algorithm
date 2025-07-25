import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(i==1 && j==1) {
                    dp[1][1]=1; //초기 설정 
                    continue;
                }
                boolean isPuddle = false;
                //해당 칸이 웅덩이 칸인지 검사
                for(int[] p : puddles){
                    if(p[0]==j && p[1]==i) { //행, 열 주의
                        isPuddle = true;
                        break;
                    }
                }
                
                //웅덩이 칸이라면
                if(isPuddle) {
                    dp[i][j]=0;
                    continue;
                }
                int ways = 0;
                //위에서 내려올 수 있다면
                if(i>1) ways += dp[i-1][j];
                //왼쪽에서 올 수 있다면
                if(j>1) ways += dp[i][j-1];
                dp[i][j]=ways % 1000000007;
            }
        }
        return dp[n][m];
    }
}