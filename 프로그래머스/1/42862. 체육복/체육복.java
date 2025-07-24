import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        int cnt = 0;
        int[] check = new int[n+1];
        
        //여분 체육복이 있는 학생 check배열 1로 설정
        for(int i=0;i<reserve.length;i++){
            int idx=reserve[i];
            check[idx]=1;
        }
        
        //여분 체육복 있는 학생이 도난당한 경우 자신 여벌 체육복을 입으므로 0으로 제거
        for(int i=0;i<lost.length;i++){
            for(int j=0;j<reserve.length;j++){
                if(lost[i]==reserve[j]){
                    check[reserve[j]]=0;
                    lost[i]=0;
                    reserve[j]=0;
                    break;
                }
            }
        }
        
        //도난 당한 학생 양 옆 학생이 여분 체육복이 있다면,
        for(int i=0;i<lost.length;i++){
            if(lost[i]==0) continue;
            int idx = lost[i];
            
            //왼쪽 학생 우선
            if(idx>1 && check[idx-1]==1){
                check[idx-1]=0;
                for(int j=0;j<reserve.length;j++){
                    if(reserve[j]==idx-1){
                        reserve[j]=0;
                        break;
                    }
                }
                lost[i]=0;
                cnt++;
            
            //오른쪽 학생
            } else if(idx < n && check[idx + 1] == 1){
                check[idx+1]=0;
                for(int j=0;j<reserve.length;j++){
                    if(reserve[j]==idx+1){
                        reserve[j]=0;
                        break;
                    }
                }
                lost[i]=0;
                cnt++;
            }
            
        }
        
        int lostnwear=0;
        for(int i=0;i<lost.length;i++){
            if(lost[i]==0) lostnwear++;
        }
        return n-lost.length+lostnwear;
    }
}