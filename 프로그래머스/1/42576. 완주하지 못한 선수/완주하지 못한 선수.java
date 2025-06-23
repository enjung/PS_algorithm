import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> hm = new HashMap<>();
        
        for (String name : participant) {
            hm.put(name, hm.getOrDefault(name, 0) + 1); //hm에 name이 없으면 value를 1로, 있으면 +1
        }
        
        for (String name : completion) {
            hm.replace(name, hm.get(name) - 1); // value 에서 -1
        }
        
        for (String name : hm.keySet()){
            if(hm.get(name)!=0){
                answer = name;
            }
        }
        return answer;
    }
}