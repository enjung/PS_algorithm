import java.util.*;

class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder(new_id);
        // 아스키코드 'a':97, '1':49x
        
        
        //1&2. 대문자 -> 소문자, 이상 문자 제거
        for(int i=0;i<sb.length();i++){ //String의 길이로하면 delete했을때 인덱스 꼬일 수 있을듯
            char c = sb.charAt(i);
            // 1.
            if(Character.isUpperCase(c)) {
                sb.setCharAt(i,Character.toLowerCase(c));
                c = sb.charAt(i);
            }
            // 2. 
            if(!((c>=48 && c<=57) || (c>=97 && c<=122) || c=='-'|| c=='_' || c=='.')) {
                sb.deleteCharAt(i);
                i--; //인덱스가 -1이 되어도 어차피 제거해야하는 문자라면 제거해야하니까 괜찮음
                continue;
            }
            // 3.
            if(c=='.' && i>0 && sb.charAt(i-1)==c ) {
                sb.deleteCharAt(i);
                i--; // .이 3회 이상 반복되는 경우가 있을 수 있으므로 다시 돌아가서 검사
                continue;
            }
            // 4.
            if((i==0 || i==sb.length()-1) && c=='.'){
                sb.deleteCharAt(i);
                i--;
                continue;
            }
        }
        
        //5.
        if(sb.length()==0) sb.append('a');
        
        //6.
        if(sb.length()>=16){
            for(int i=15;i<sb.length();i++){
                sb.deleteCharAt(i);
                i--;
            }
        }
        if(sb.charAt(sb.length()-1)=='.') sb.deleteCharAt(sb.length()-1);
        
        //7.
        if(sb.length()<=2){
            char c = sb.charAt(sb.length()-1);
            while(sb.length()!=3){
                sb.append(c);
            }
        }
        
        String answer = sb.toString();
        return answer;
    }
}