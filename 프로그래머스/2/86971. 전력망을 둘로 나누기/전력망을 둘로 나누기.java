import java.util.*;

class Solution {
    static int answer = Integer.MAX_VALUE;
    static List<List<Integer>> graph;
    static int[] visited;
    
    public int solution(int n, int[][] wires) {
        
        //그래프를 인접리스트에 저장, List<List<Integer>>로 구현
        graph = new ArrayList<>();
        //각 노드 연결리스트 초기화
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        //연결정보 저장
        for(int[] wire : wires){
            int a = wire[0];
            int b = wire[1];
            graph.get(a).add(b);
            graph.get(b).add(a); //양방향 그래프이므로
        }
        
        //전선 하나씩 끊어보면서 차이 최소인지 체크
        for(int[] wire: wires){
            int a = wire[0];
            int b = wire[1];
            
            //remove(b)는 인덱스b 위치의 값을 제거하는것, b를 제거하고싶으면 Object형으로 넣어줘야함
            graph.get(a).remove((Integer)b);
            graph.get(b).remove((Integer)a);
            
            visited = new int[n+1];
            int cnt = dfs(1); //1번 노드에서 시작
            int dif = Math.abs(cnt-(n-cnt));
            answer = Math.min(answer,dif);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        return answer;
    }
    
    public int dfs(int node){
        visited[node] = 1;
        int cnt = 1;
        
        for(int n : graph.get(node)){
            if(visited[n]==0){
                cnt += dfs(n);
            }
        }
        return cnt;
    }
}