import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][]dp = new int[n+1][m+1];
        //dp[1][1]=1;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(i==1&&j==1){
                    dp[1][1]=1;
                    continue;
                }
                
                //웅덩이칸인지 검사
                boolean isPuddle = false;
                for(int[] puddle : puddles){
                    if(puddle[0]==j && puddle[1]==i){
                        isPuddle = true;
                        break;
                    }
                }
                //웅덩이 칸이면,
                if(isPuddle){
                    dp[i][j]=0;
                    continue;
                }
                
                int ways = 0;
                //아래로 이동한 경우
                if(i>1){
                    ways += dp[i-1][j];
                }
                //오른쪽으로 이동한 경우
                if(j>1){
                    ways += dp[i][j-1];
                }
                
                dp[i][j] = ways % 1000000007;
            }
        }
        return dp[n][m];
    }
}