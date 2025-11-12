import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        Queue<String> q = new LinkedList<>();
        q.add(begin);
        String word = begin;
        
        int depth = 0;
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int s=0;s<size;s++){
                word = q.poll();
                if(word.equals(target)) return answer;
            
                for(int i=0;i<words.length;i++){
                    if(!visited[i] && isOneDif(word,words[i])){
                        visited[i]=true;
                        q.add(words[i]);
                    }
                }
            }
            answer++;
        }
        return 0;
        
    }
    
    
    public boolean isOneDif(String word1, String word2){
        int cnt = 0;
        for(int i=0;i<word1.length();i++){
            if(word1.charAt(i)!=word2.charAt(i)) cnt++;
        }
        if(cnt==1) return true;
        else return false;
    }
}