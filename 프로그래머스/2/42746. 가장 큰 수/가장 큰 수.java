import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        
        // 1. 숫자 배열을 문자열 배열로 변환
        String[] strNums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNums[i] = String.valueOf(numbers[i]);
            //int -> String , String.valueOf()사용
        }

        // 2. 정렬: 큰 조합이 앞에 오도록
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // 3. 예외 처리: 000 같은 경우 → "0"
        if (strNums[0].equals("0")) {
            return "0";
        }

        // 4. 문자열 합치기
        //+연산자 써서 붙이는 것보다 StringBuilder와 append를 쓰는 게 더 효율적
        StringBuilder sb = new StringBuilder();
        for (String s : strNums) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}