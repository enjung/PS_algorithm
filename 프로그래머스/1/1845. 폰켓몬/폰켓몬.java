import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length/2;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i:nums){
            if(hm.containsKey(i)) hm.put(i,hm.get(i)+1);
            else{
                hm.put(i,1);
            }
        }
        if(hm.size()<n) answer = hm.size();
        else answer = n;
        return answer;
    }
}

