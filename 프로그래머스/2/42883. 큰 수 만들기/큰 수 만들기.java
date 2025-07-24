import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        for(char c : number.toCharArray()){
            while(k>0 //아직 제거할 숫자가 남았고
                  && sb.length()>0 //sb가 비어있지 않고
                  && sb.charAt(sb.length()-1) < c) //sb의 마지막 숫자보다 더 큰 숫자라면
            {
                k--;
                sb.deleteCharAt(sb.length()-1); //sb의 마지막 숫자 제거
                
            }
            
            //c보다 작은건 sb에서 제거했으므로 이제 c를 넣으면 됨
            sb.append(c);
        }
        
        //순회가 끝났지만 아직 k가 0이 안 됐다면, 뒤에서부터 k개 제거
        sb.setLength(sb.length()-k);
        
        return sb.toString();
    }
}