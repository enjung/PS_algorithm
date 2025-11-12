import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        int n = maps.length; //세로
        int m = maps[0].length; //가로
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0,1});  //출발:(0,0), 도착:(n-1,m-1)
        
        while(!q.isEmpty()){
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];
            int len = p[2];
            if(x==n-1 && y ==m-1) {
                answer = len;
                break;
            }
            
            for(int k=0;k<4;k++){
                int nx = x+dy[k];
                int ny = y+dx[k];
                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(maps[nx][ny]==1 && !visited[nx][ny]){
                        visited[nx][ny]=true;
                        q.add(new int[] {nx,ny,len+1});
                    }
                }
            }
        }
        return answer;
    }
    
}