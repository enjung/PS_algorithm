import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String,Integer> map = new HashMap<>();
        int answer = 1;
        for( String[] cloth : clothes ){
            if(map.containsKey(cloth[1])){
                map.replace(cloth[1],map.get(cloth[1])+1);
            }
            else{
                map.put(cloth[1],1);
            }
        }
        for( String key : map.keySet()){
            answer *= map.get(key)+1;
        }
        
        return answer-1;
    }
}