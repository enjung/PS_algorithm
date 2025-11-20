import java.util.*;

class Solution {
    int n;
    boolean[] visited;
    String[] answer;
    boolean finished;
    
    public String[] solution(String[][] tickets) {
        
        // 먼저 정렬하기
        Arrays.sort(tickets,(a,b)->{
            if(a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });
        
        n = tickets.length;
        visited = new boolean[n];
        answer = new String[n+1];
        
        for(int i=0;i<n;i++){
            // i번째 티켓이 첫 방문 티켓
            if(tickets[i][0].equals("ICN")){
                String arr = tickets[i][1];
                answer[0] = tickets[i][0];
                answer[1] = tickets[i][1];
                visited[i]=true;
                dfs(arr,2,tickets); //두 곳을 방문했고, 다음 answer index도 2가 됨
                visited[i]=false;
                if(finished) break; //이미 찾았으면 더 돌면서 덮어쓰지말고 끝내기
            }
        }
        return answer;
    }
    
    
    public void dfs(String arr,int cnt, String[][] tickets){
        if(finished) return;
        if(n+1==cnt){
            finished = true;
            return;
        }
        for(int j=0;j<n;j++){
            if(tickets[j][0].equals(arr) &&!visited[j]){
                answer[cnt]=tickets[j][1];
                visited[j] = true;
                dfs(tickets[j][1],cnt+1,tickets);
                visited[j] = false;
                if(finished) return; //이미 찾았으면 더 돌면서 덮어쓰지말고 끝내기
            }
        }
    }
}