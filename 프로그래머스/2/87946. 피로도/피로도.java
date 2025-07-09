import java.util.*;

class Solution {
    static int answer = 0;
    int[] visited;

    public int solution(int k, int[][] dungeons) {
        visited = new int[dungeons.length];
        dfs(k,dungeons, 0);
        return answer;
    }
    
    
    public void dfs(int k, int[][] dungeons, int depth){
        answer = Math.max(answer,depth);
        
        for(int i=0;i<dungeons.length;i++){
            if(visited[i]==0 && k>=dungeons[i][0]){
                visited[i]=1;
                dfs(k-dungeons[i][1], dungeons,depth+1);
                visited[i]=0; //백트래킹
            }
        }
        
    }
}