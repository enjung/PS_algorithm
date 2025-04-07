import java.util.*;
class Node{
    private int x;
    private int y;
    
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
}
class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    int n,m = 0;
    int[][] map = new int[101][101];
    int[][] visited = new int[101][101];

    public void bfs(int a, int b){
        Queue<Node> q = new LinkedList<>();
        //시작점
        q.offer(new Node(a,b));
        visited[a][b]=1;
        
        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.getX();
            int y = node.getY();
            
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx<1||nx>n||ny<1||ny>m){
                    continue;
                }
                if(map[nx][ny]==1 && visited[nx][ny]==0){
                    visited[nx][ny]=1;
                    q.offer(new Node(nx,ny));
                    map[nx][ny]=map[x][y]+1;
                }
            }            
            
        }

    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        
        //인덱스를 좌표로 보기 위해 maps->map 재입력
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i+1][j+1]=maps[i][j];
            }
        }
        
        //bfs
        bfs(1,1);
        
        if(map[n][m]==1){
            return -1;
        }
        else{
            answer=map[n][m];
        }
    
        return answer;
    }
}