import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();

        // 큐에 [우선순위, 인덱스] 형태로 저장
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[] { priorities[i], i });
        }

        int order = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.remove();
            boolean hasHigher = false;

            // 현재보다 높은 우선순위가 하나라도 있으면 다시 뒤로 보냄
            for (int[] p : queue) {
                if (p[0] > current[0]) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                queue.add(current); // 뒤로 보내기
            } else {
                order++;
                if (current[1] == location) {
                    return order;
                }
            }
        }

        return -1; // 이론상 도달 불가
    }
}