import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        
        //모든 전화번호를 Set에 넣기
        for (String number : phone_book) {
            set.add(number);
        }

        //각 전화번호의 접두사 prefix를 하나씩 만들어보며 검색
        for (String number : phone_book) {
            for (int i = 1; i < number.length(); i++) {
                String prefix = number.substring(0, i);
                if (set.contains(prefix)) {
                    return false;
                }
            }
        }

        return true;
    }
}
