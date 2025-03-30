import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int i,j,n,start_index,k=0;
        for(i=0;i<commands.length;i++){
            start_index=commands[i][0]-1;
            n=commands[i][1]-commands[i][0]+1;
            k=commands[i][2];
            int[] tmp = new int [n];
            
            for(j=0;j<n;j++){
                tmp[j]=array[start_index+j];
            }
            Arrays.sort(tmp);
            answer[i]=tmp[k-1];
        }
        return answer;
    }
}