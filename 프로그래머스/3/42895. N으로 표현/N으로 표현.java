import java.util.*;
//이어붙이는경우, 기존조합으로 사칙연산
//초기값 dp[1]={N}
class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>(9);
        for(int i=0;i<=8;i++){
            dp.add(new HashSet<>());
        }
        
        for(int i=1;i<=8;i++){
            //단순 이어붙이는 경우
            int concat = 0;
            for(int k=0;k<i;k++){
                concat = concat*10 + N;
            }
            dp.get(i).add(concat);
            
            //기존 조합으로 사칙연산
            for(int j=1;j<i;j++){
                for(int a : dp.get(j)){
                    for(int b : dp.get(i-j)){
                        dp.get(i).add(a+b);
                        dp.get(i).add(a-b);
                        dp.get(i).add(a*b);
                        if(b!=0){
                            dp.get(i).add(a/b);
                        }
                    }
                    
                    
                }
            }
            
            //number가 dp에 있다면
            if(dp.get(i).contains(number)){
                return i;
            }
            
        }
        
        //8까지 돌아도 dp에 없다면
        return -1;
    }
}