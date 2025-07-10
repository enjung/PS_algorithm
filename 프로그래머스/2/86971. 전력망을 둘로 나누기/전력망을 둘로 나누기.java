import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    List<List<Integer>> graph = new ArrayList<>();
    int[] visited;
    
    public int solution(int n, int[][] wires) {
        visited = new int[n+1]; //1번 인덱스부터 쓸거니까 n+1 사이즈
        
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        
        //연결정보 저장
        for(int wire[] : wires){
            int a = wire[0];
            int b = wire[1];
            graph.get(a).add(b); //a 노드의 인접 리스트 중 b를 설정
            graph.get(b).add(a); //b 노드의 인접 리스트 중 a를 설정
        }
        
        
        //하나씩 끊어보기
        for(int wire[] : wires){
            int a = wire[0];
            int b = wire[1];
            graph.get(a).remove((Integer)b);
            graph.get(b).remove((Integer)a);
            
            //끊을때마다 visited 초기화
            visited = new int[n+1];
            //1번 노드에서 dfs 시작
            int cnt = dfs(1);
            //두 네트워크 크기 업데이트
            int diff = Math.abs(cnt - (n-cnt));
            answer = Math.min(answer,diff);
            
            //끊은 전선 다시 복구 (=백트래킹?)
            graph.get(a).add(b);
            graph.get(b).add(a);
            
        }
        return answer;
    }
    
    public int dfs(int k){
        visited[k]=1;
        int count = 1;
        for (int next : graph.get(k)) {
            if (visited[next] == 0) {
                count += dfs(next);
            }
        }
        return count;
    }
}