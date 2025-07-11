import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    List<List<Integer>> graph = new ArrayList<>();
    int[] visited;
    
    public int solution(int n, int[][] wires) {
        
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        
        visited = new int[n+1];
        
        //연결정보
        for(int[] wire: wires){
            int a = wire[0];
            int b = wire[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    
        //하나씩 끊어보기
        for(int[] wire: wires){
            int a = wire[0];
            int b = wire[1];
            graph.get(a).remove((Integer)b);
            graph.get(b).remove((Integer)a);
            
            
            visited = new int[n+1];
            //dfs로 덩어리 하나 사이즈 구하기
            int cnt = dfs(1); //1번노드부터 시작한 사이즈
            
            //정답 업데이트
            int dif= Math.abs(cnt-(n-cnt));
            answer = Math.min(answer,dif);
            
            //끊은 전선 복구
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        return answer;
    }
    
    public int dfs(int k){
        int count = 1;
        visited[k]=1;
        
        for(int node : graph.get(k)){
            if(visited[node]==0){
                count += dfs(node);
            }
        }
        return count;
    }
}