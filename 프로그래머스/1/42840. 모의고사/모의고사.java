import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        int[] score = new int[3];
        int fi = 0;
        int si = 0;
        int ti = 0;
        for(int n : answers){
            if(fi>=5) fi=0;
            if(si>=8) si=0;
            if(ti>=10) ti=0;
            
            if(first[fi]==n) score[0]++;
            if(second[si]==n) score[1]++;
            if(third[ti]==n) score[2]++;
            
            fi++;
            si++;
            ti++;
        }
        int max = Math.max(score[0],Math.max(score[1],score[2]));
        if(score[0]==max) answer.add(1);
        if(score[1]==max) answer.add(2);
        if(score[2]==max) answer.add(3);

        return answer.stream().mapToInt(i -> i).toArray();
    }
}