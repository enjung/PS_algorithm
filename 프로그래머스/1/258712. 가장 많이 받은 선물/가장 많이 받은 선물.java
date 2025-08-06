import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        int[] cal = new int[n];
        int[] counts = new int[n];
        
        //선물지수 계산
        for(int i=0;i<n;i++){
            int a = 0;
            int b = 0;
            for(String gift : gifts){
                if(gift.startsWith(friends[i]+" ")) a++;
                if(gift.endsWith(" "+friends[i])) b++;
            }
            cal[i]=a-b;
        }
        

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int a=0;
                int b=0;
                for(String gift:gifts){
                    String[] parts = gift.split(" ");
                    if (parts[0].equals(friends[i]) && parts[1].equals(friends[j])) a++;
                    if (parts[0].equals(friends[j]) && parts[1].equals(friends[i])) b++;
                }
                //다음달에 b가 하나 받는 경우
                if(a<b) counts[j]++;
                //다음달에 a가 하나 받는 경우
                else if(a>b) counts[i]++;
                //주고받은 수가 같아서 선물지수가 큰 사람이 받음
                else{
                    if(cal[i]>cal[j]) counts[i]++;
                    if(cal[i]<cal[j]) counts[j]++;
                }
            }
        }
        
        Arrays.sort(counts);
        return counts[n-1];
    }
}