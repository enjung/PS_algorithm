import java.util.*;

class Solution {
    static String[] vowels = {"A", "E", "I", "O", "U"};
    static int index = 0;
    static int answer = 0;
    
    public int solution(String word) {
        dfs("",word);
        return answer;
    }
    
    private void dfs(String current, String target) {
        if (current.equals(target)) {
            answer = index;
            return;
        }

        index++;

        if (current.length() == 5) return;

        for (int i = 0; i < 5; i++) {
            dfs(current + vowels[i], target);
        }
    }
}