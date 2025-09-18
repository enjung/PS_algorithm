import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        int[] correct = new int[3];
        for(int i=0;i<answers.length;i++){
            if(answers[i]==first[i%5])correct[0]++;
            if(answers[i]==second[i%8])correct[1]++;
            if(answers[i]==third[i%10])correct[2]++;
        }
        int maxCnt = Math.max(correct[0],Math.max(correct[1],correct[2]));
        
        // 
        List<Integer> ls = new ArrayList<>();
        
        for(int i=0;i<3;i++){
            if(maxCnt==correct[i]) ls.add(i+1);
        }
        
        int[] answer = new int[ls.size()];
        for(int i=0;i<ls.size();i++){
            answer[i]=ls.get(i);
        }
        return answer;
    }
}