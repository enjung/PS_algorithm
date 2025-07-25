import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int boat = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;
        while(left<=right){
            if(left==right) {
                boat++;
                break;
            }
            int sum = people[left]+people[right];
            if(sum<=limit){
                right--;
                left++;
            }
            else{
                right--;
            }
            boat++;
        }
        return boat;
    }
}