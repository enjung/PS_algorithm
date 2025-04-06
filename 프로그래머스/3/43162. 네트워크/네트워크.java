class Solution {
    int[] visited = new int[200];
    
    public void dfs(int i,int[][] computers){
        visited[i]=1;
        
        for(int j=0;j<computers.length;j++){
            if(visited[j]==0 && computers[i][j]==1){
                dfs(j,computers);
            }
        }
    
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfs(i,computers);
                answer++;
            }
        }
        return answer;
    }
}