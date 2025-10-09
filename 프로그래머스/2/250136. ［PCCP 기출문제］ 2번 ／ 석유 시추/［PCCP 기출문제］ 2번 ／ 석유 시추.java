import java.util.*;

//롤백포인트

class Solution {
    //경계값 검사 필요
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    HashMap<Integer,Integer> hm = new HashMap<>();
    int answer = 0;
    
    public int solution(int[][] land) {
        
        int x = land[0].length;
        int y = land.length;
        boolean[][] visited = new boolean[y][x];
        
        
        for(int i=0;i<y;i++){
            for(int j=0;j<x;j++){
                if(land[i][j]==1 && !visited[i][j]){
                    bfs(i,j,land,visited);
                }
            }
        }
        
        //맵돌면서 최대값 검출
        for(int k : hm.keySet()){
            if(answer<hm.get(k)) answer=hm.get(k);
        }
        return answer;
    }
    
    
    public void bfs(int i,int j,int[][] land,boolean[][] visited){
        visited[i][j]=true;
        //i좌표랑 석유량 매핑해서 저장
        Queue<int[]>q = new LinkedList<>();
        int[] tmpx = new int[land[0].length];
        tmpx[j]=1;
        q.offer(new int[]{i,j});
        int cnt = 1;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            for(int d=0;d<4;d++){
                int xi = x+dx[d];
                int yi = y+dy[d];
                //경계를 벗어나지 않고,
                if(xi>=0 && xi<land[0].length && yi>=0 && yi<land.length){
                    //방문 전인 석유가 있는 좌표라면
                    if(land[yi][xi]==1 && !visited[yi][xi]){
                        q.offer(new int[]{yi,xi});
                        visited[yi][xi]=true;
                        cnt++;
                        tmpx[xi]=1;
                    }
                }
            }
        
        }
        
        for(int k=0;k<land[0].length;k++){
            if(tmpx[k]==1) hm.put(k,hm.getOrDefault(k,0)+cnt);
        }

    }
}
//시추관 위치마다 같은 덩어리에서의 석유량을 계속 계산하면 효율성에서 점수 깎일듯
//2중 for문으로 한번에 bfs를 끝낸다음 마지막에 좌표별 석유량만 더하기
//bfs결과는 좌표랑 석유량 묶어서 저장, 근데 bfs를 어떻게 했더라 ...