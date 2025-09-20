import java.util.*;

class Solution {
    String[] dic = {"A","E","I","O","U"};
    int answer = 0;
    int cnt = 0;
    
    public int solution(String word) {
        dfs(word,"");
        return answer;
    }
    
    public void dfs(String word, String cur){
        if(cur.length()>5) return;
        if(cur.equals(word)) {
            answer = cnt;
            return;
        }
        
        cnt++;
        
        for(int i=0;i<5;i++){
            dfs(word,cur+dic[i]);
        }
    
    }
}