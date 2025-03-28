import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int pick_num = nums.length/2;
        HashSet<Integer> hs = new HashSet<>();
        for (int i=0;i<nums.length;i++){
           hs.add(nums[i]);
        }
        if(hs.size()>pick_num){
            answer=pick_num;
        }
        else{
            answer=hs.size();
        }
        return answer;
    }
}