import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        //자를 덩어리 수를 1부터 늘려감
        for(int i=1;i<=s.length()/2;i++){ //절반보다 큰 덩어리가 반복될 순 없음
            int cnt = 1; // 압축된 덩어리 수
            String prev = s.substring(0,i); //타겟 패턴(첫 덩어리)
            StringBuilder sb = new StringBuilder(); //압축된 문자열
            
            //다음 덩어리부터 i개씩 이전 타겟과 같은지 검사
            int j = i;
            for(; j+i<=s.length();j=j+i){
                String next = s.substring(j,j+i);
                if(next.equals(prev)) cnt++;
                else{
                    //압축된 덩어리 수가 1이면 압축x
                    if(cnt>1) sb.append(cnt);
                    sb.append(prev);
                    prev = next;
                    cnt=1;
                }
            }
            //i개로 떨어지지 않는 나머지는 그대로 붙여줌
            if(cnt>1) sb.append(cnt);
            sb.append(prev);
            if(s.length()%i!=0) sb.append(s.substring(j,s.length()));
            
            answer = Math.min(sb.length(),answer);
        }
        
        
        return answer;
    }
}
