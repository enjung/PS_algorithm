import java.util.*;

class Solution {
    static class Node{
        String word;
        int depth;
        
        Node(String word, int depth){
            this.word=word;
            this.depth=depth;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        q.offer(new Node(begin,0));
        //visited[]
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.word.equals(target)) return cur.depth;
            for(int i=0;i<words.length;i++){
                if(!visited[i]&&convertible(cur.word, words[i])){
                    q.offer(new Node(words[i], cur.depth+1));
                    visited[i]=true;
                }
            }
        }
        return answer;
    }
    public boolean convertible(String word1, String word2){
        int dif=0;
        for(int i=0;i<word1.length();i++){
            if(word1.charAt(i) != word2.charAt(i)) dif++;
        }
        if(dif==1) return true;
        else return false;
    }
}