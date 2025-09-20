import java.util.*;

class Solution {
    boolean[] visited;
    List<List<Integer>> graph = new ArrayList<>();
    int answer = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] w : wires){
            int a = w[0];
            int b = w[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for(int[] w : wires){
            int a = w[0];
            int b = w[1];
            graph.get(a).remove((Integer)b);
            graph.get(b).remove((Integer)a);
            
            visited = new boolean[n+1];
            int cnt = dfs(1);
            int diff = Math.abs(cnt -(n-cnt));
            answer = Math.min(answer,diff);
            
            graph.get(a).add(b);
            graph.get(b).add(a);
            
        }
        return answer;
    }
    
    
    public int dfs(int node){
        visited[node] = true;
        int cnt = 1;
        for(int next : graph.get(node)){
            if(!visited[next]){
                cnt += dfs(next); 
            }
        }
        return cnt;
    }
}