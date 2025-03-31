import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations); // 오름차순 정렬
        int n = citations.length;

        for (int i = n; i >= 0; i--) { // i: H-index 후보값 (가장 큰 값부터 감소)
            int cnt = 0;

            // 뒤에서부터 i 이상인 값 세기
            for (int j = n - 1; j >= 0; j--) {
                if (citations[j] >= i) {
                    cnt++;
                } else {
                    break; // 오름차순이니까 더 이상 안 봐도 됨
                }
            }

            if (cnt >= i) {
                return i; // 조건 만족 시 바로 반환
            }
        }

        return 0; // 못 찾은 경우
    }
}