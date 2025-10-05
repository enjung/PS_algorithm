import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {

        // ① 포인트 번호 → 좌표 매핑
        Map<Integer, int[]> pointMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            pointMap.put(i + 1, points[i]); // 포인트 번호는 1부터 시작
        }

        // ② 시간별 좌표별 로봇 개수를 저장하는 Map
        // timeMap[시간] → { "r,c" : 몇 대 }
        Map<Integer, Map<String, Integer>> timeMap = new HashMap<>();
        int maxTime = 0; // 전체 시뮬레이션 시간의 최대값

        // ③ 각 로봇에 대해 이동 시뮬레이션 수행
        for (int[] route : routes) {
            int time = 0;

            // 시작 좌표
            int[] cur = Arrays.copyOf(pointMap.get(route[0]), 2);
            record(timeMap, time, cur); // 0초에 현재 위치 기록

            // 순서대로 다음 포인트까지 이동
            for (int i = 1; i < route.length; i++) {
                int[] next = pointMap.get(route[i]);

                // 다음 포인트까지 최단거리 이동 (r 먼저, c 나중)
                while (cur[0] != next[0] || cur[1] != next[1]) {
                    if (cur[0] != next[0]) { // r(세로) 먼저 맞추기
                        cur[0] += (next[0] > cur[0]) ? 1 : -1;
                    } else { // 그 다음 c(가로)
                        cur[1] += (next[1] > cur[1]) ? 1 : -1;
                    }
                    time++;
                    record(timeMap, time, cur);
                }
            }

            maxTime = Math.max(maxTime, time);
        }

        // ④ 모든 시간대별 충돌 위험 횟수 계산
        int dangerCount = 0;
        for (int t = 0; t <= maxTime; t++) {
            Map<String, Integer> positions = timeMap.get(t);
            if (positions == null) continue;

            for (int count : positions.values()) {
                if (count >= 2) dangerCount++; // 같은 좌표에 2대 이상
            }
        }

        return dangerCount;
    }

    // 현재 좌표(cur)를 해당 시각(time)에 기록하는 헬퍼 함수
    private void record(Map<Integer, Map<String, Integer>> timeMap, int time, int[] cur) {
        String key = cur[0] + "," + cur[1];
        timeMap.putIfAbsent(time, new HashMap<>());
        Map<String, Integer> m = timeMap.get(time);
        m.put(key, m.getOrDefault(key, 0) + 1);
    }
}
