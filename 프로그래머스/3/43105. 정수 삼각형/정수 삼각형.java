class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        int[][] dp = new int[n][n];
        
        //초기화
        dp[0][0]=triangle[0][0];
        
        //dp채우기
        for(int i=1;i<n;i++){
            //첫번째 열
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            //제일 마지막 열
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
            //양끝 경계를 제외한 가운데 값들
            for(int j=1;j<i;j++){
                dp[i][j]= Math.max(dp[i-1][j],dp[i-1][j-1])+triangle[i][j];
            }
            
        }
        
        //마지막 행에서 가장 dp가 제일 큰 값이 정답
        for(int j=0; j<n; j++){
            answer = Math.max(dp[n-1][j], answer);
        }
        return answer;
    }
}