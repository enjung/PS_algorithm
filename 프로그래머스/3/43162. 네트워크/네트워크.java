import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        
        boolean visited[] = new boolean[n];
        int answer = 0;
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(computers,visited,n,i);
                answer++; 
                //dfs안에서 answer++하는게 아니라, dfs가 끝나야 하나의 덩어리가 끝난것이므로 dfs 호출 끝나면 증가
            }
        }
        return answer;
    }
    
    public void dfs(int[][] computers, boolean[] visited,int n, int i){
        //dfs호출 조건에 방문여부를 이미 확인했으므로 바로 방문함으로 체크
        visited[i]=true;
        for(int j=0;j<n;j++){
            if(!visited[j]&&computers[i][j]==1){
                dfs(computers,visited,n,j);
            }
        }
    }
}