import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] answer = new int[3];
        int idx=0;
        int p=0;
        int q=0;
        int r=0;
        int c1=0;
        int c2=0;
        int c3=0;
        for(int i=0;i<answers.length;i++,p++,q++,r++){
            if(p==5) p=0;
            if(q==8) q=0;
            if(r==10) r=0;
            if(answers[i]==one[p]) c1++;
            if(answers[i]==two[q]) c2++;
            if(answers[i]==three[r]) c3++;
        }
        
        int max = Math.max(c1,Math.max(c2,c3));
        if(max==c1) answer[idx++]=1;
        if(max==c2) answer[idx++]=2;
        if(max==c3) answer[idx++]=3;
        
        //idx는 0이 아닌 값이 배열에 몇개 들어가있는지
        return Arrays.copyOf(answer, idx);
    }
}