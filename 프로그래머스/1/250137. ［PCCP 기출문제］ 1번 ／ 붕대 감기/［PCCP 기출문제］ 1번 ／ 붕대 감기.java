import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int cons = 0;
        int nextAttackIdx = 0;
        int maxH = health;
        for(int i=1;i<=attacks[attacks.length-1][0];i++){ //i는 시간과 같음
            //공격을 받았다면,
            if(attacks[nextAttackIdx][0]==i){
                cons = 0; //연속 성공 초기화
                health -= attacks[nextAttackIdx][1];
                nextAttackIdx++;
                // //마지막 공격이었다면 최종 체력 반환
                // if(nextAttackIdx==attacks.length) answer = health;
                
                //공격이 남았더라도 현재 체력이 0 이하라면 -1 반환
                if(health<=0){
                    return -1;
                }
                
            }
            
            //공격이 없어야만 회복 가능
            else{
                
                if(health+bandage[1]>maxH) health=maxH;//최대 체력을 넘길 수 없음
                else health+=bandage[1]; //x만큼 체력회복
                cons++;
                
                //연속 성공이라면 추가 체력 회복
                if(cons==bandage[0]){
                    cons = 0; //초기화
                    health+=bandage[2];
                    if (health > maxH) health = maxH;
                }
            }

        }
        return health;
    }
}