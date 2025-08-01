import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int[] d : dir ){
                int nx = x + d[0];
                int ny = y + d[1];
                
                if( nx>=0 && nx<n && ny >=0 && ny<m && maps[nx][ny]==1){
                    q.offer(new int[]{nx,ny});
                    maps[nx][ny] = maps[x][y]+1;
                }
            }
            
        }
        
        if(maps[n-1][m-1]==1) return -1;
        else return maps[n-1][m-1];
    }
}