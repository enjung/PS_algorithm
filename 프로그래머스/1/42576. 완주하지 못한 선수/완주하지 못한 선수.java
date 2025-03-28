import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        String answer = "";
        HashMap <String,Integer> part = new HashMap<String,Integer>();
        
        for(int i=0;i<participant.length;i++){
            if(part.containsKey(participant[i])){
                part.replace(participant[i],part.get(participant[i])+1);
            }else{
                part.put(participant[i],1); 
            }
        }
        
        for(int i=0;i<completion.length;i++){
            part.replace(completion[i], part.get(completion[i])-1);
            //System.out.print(part.get(completion[i]));      
        }
        
        for(String name : part.keySet()){
            if(part.get(name)!=0){
                return name;
            }
        }
        return answer;
    }
}