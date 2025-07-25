import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // dp[i]: N을 i번 사용해서 만들 수 있는 값들의 집합
        List<Set<Integer>> dp = new ArrayList<>(9); //1~8 인덱스 쓰기 위해서 0~8까지 생성
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        // 1부터 8까지 차례로 채워 나가며
        for (int i = 1; i <= 8; i++) {
            // 1) 숫자 이어붙이기
            int concat = 0;
            for (int k = 0; k < i; k++) {
                concat = concat * 10 + N;
            }
            dp.get(i).add(concat);

            // 2) 이전 상태 조합: j번 + (i−j)번 → 사칙연산
            for (int j = 1; j < i; j++) {
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i - j)) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b != 0) { //0으로는 나눌 수 없으므로
                            dp.get(i).add(a / b);
                        }
                    }
                }
            }

            // 3) 목표 숫자(number) 가 dp[i]에 들어있는지 확인
            if (dp.get(i).contains(number)) {
                return i;
            }
        }

        // 8번까지 써도 못 만들면 -1
        return -1;
    }
}
