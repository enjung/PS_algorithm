import java.util.*;

class Solution {
    static class Word{
        String word;
        int depth;
        
        Word(String word, int depth){
            this.word = word;
            this.depth = depth;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        Queue<Word> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        q.offer(new Word(begin,0));
        
        while(!q.isEmpty()){
            Word cur = q.poll();
            
            if(cur.word.equals(target)){
                return cur.depth;
            }
            
            for(int i=0;i<words.length;i++){
                if(!visited[i] && isOneDiff(cur.word, words[i])){
                    visited[i]=true;
                    q.offer(new Word(words[i], cur.depth+1));
                }
            }
        }
        
        return 0;
    }
    
    public boolean isOneDiff(String a, String b){
        int diff = 0;
        for(int i=0;i<a.length();i++ ){
            if(a.charAt(i)==b.charAt(i)) continue;
            else diff++;
        }
        if(diff==1) return true;
        else return false;
    }
}