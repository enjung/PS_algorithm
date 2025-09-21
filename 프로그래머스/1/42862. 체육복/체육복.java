import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int answer = 0;
        int[] clothes = new int[n+2];
        Arrays.fill(clothes,1);
        for(int r : reserve){
            clothes[r]++;
        }
        for(int l : lost){
            clothes[l]--;
        }
        for(int i=1;i<=n;i++){
            if(clothes[i]==0){
                if(clothes[i-1]==2){
                    clothes[i-1]=1;
                    clothes[i]=1;
                }   
                else if(clothes[i+1]==2){
                    clothes[i+1]=1;
                    clothes[i]=1;
                }
            }
            
        }
        
        for(int i=1;i<=n;i++){
            if(clothes[i]!=0) answer++;
        }
    
        return answer;
        
    }
}