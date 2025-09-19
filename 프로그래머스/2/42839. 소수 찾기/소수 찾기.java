import java.util.*;

class Solution {
    Set<Integer> numbersSet = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        
        for(int i=1;i<=numbers.length();i++){
            boolean[] visited = new boolean[numbers.length()];
            permutation(numbers,"",i,visited); //길이가 i인 순열
        }
        
        for(int num : numbersSet){
            if(isPrime(num)) answer++;
        }
        return answer;
    }
    
    public void permutation(String numbers, String cur, int length, boolean[] visited){
        if(cur.length()==length){
            numbersSet.add(Integer.parseInt(cur));
            return;
        }
        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){
                visited[i]=true;
                permutation(numbers,cur+numbers.charAt(i),length,visited);
                visited[i]=false;
            }
        }
        
    }
    
    public boolean isPrime(int n){
        if (n<=1) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
}