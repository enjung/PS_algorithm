import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        
        boolean [] visited = new boolean[n+1];
        int[] dis = new int[n+1];
        
        for(int[] e : edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1]=true;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : graph.get(cur)){
                if(!visited[next]){
                    visited[next]=true;
                    dis[next] = dis[cur]+1;
                    q.offer(next);
                }
            }
        }
        int max = 0;
        for(int d : dis){
            if(d>max) max=d;
        }
        
        int answer = 0;
        for(int i=1;i<=n;i++){
            if(dis[i]==max) answer++;
        }
        return answer;
    }
}