import java.util.*;

class Solution {
    public int solution(String name) {
        int n = name.length();
        int upDown = 0;
        
        //상하 조작 횟수
        for(int i=0; i<n; i++){
            char c = name.charAt(i);
            upDown += Math.min(c-'A', 'Z'-c+1);
        }
        
        //첫 번째 케이스, 방향 전환 없는 좌우 조작 횟수
        int minMove = n-1;
        
        //나머지 두가지 케이스
        for(int i=0;i<n;i++){
            int next = i+1;
            while(next<n && name.charAt(next)=='A') next++;
            // 이제 next는 A블럭이 끝난 다음 상하조작이 필요한 위치
            
            int noSwitch = n-1;
            int forBack = 2*i + (n-next); //두 번째 케이스, 정->역
            int backFor = i + 2*(n-next); //세 번째 케이스, 역->정
            
            minMove = Math.min(minMove,Math.min(noSwitch, Math.min(forBack,backFor)));
        }
        
        return upDown+minMove;
    }
}