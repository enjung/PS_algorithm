import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length/2;
        HashMap<Integer,Integer> hm = new HashMap<>();
        Arrays.sort(nums);
        for(int i : nums){
            if(answer>=n) return answer; 
            if(! hm.containsKey(i)){
                hm.put(i,1);
                answer++;
            }
        }
        return answer;
    }
}