import java.util.*;

class Solution {
    int cnt = 0;
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        for(int i=0; i<n;i++){
            if(!visited[i]) {
                dfs(n,i,computers);
                cnt++;
            }
        }
        return cnt;
    }
    public void dfs(int n, int i, int[][] computers){
        visited[i]=true;
        for(int j=0;j<n;j++){
            //i==j여도 어차피 visited 조건으로 걸러짐
            if(computers[i][j]==1 && !visited[j]) dfs(n,j,computers);
        }
    }
}