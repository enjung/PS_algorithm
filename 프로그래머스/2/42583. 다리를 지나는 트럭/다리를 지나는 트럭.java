import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int totalWeight = 0;

        for (int truck : truck_weights) {
            // 1초 단위 시뮬레이션
            while (true) {
                // 다리가 비어있으면 바로 트럭 올림
                if (bridge.isEmpty()) {
                    bridge.offer(truck);
                    totalWeight += truck;
                    time++;
                    break;
                }
                // 다리가 꽉 찼을 경우 (bridge_length 초 유지됨)
                else if (bridge.size() == bridge_length) {
                    totalWeight -= bridge.poll();
                }
                // 무게 허용 시 트럭 추가
                else {
                    if (totalWeight + truck <= weight) {
                        bridge.offer(truck);
                        totalWeight += truck;
                        time++;
                        break;
                    } else {
                        // 못 올라가면 빈 공간 채우기 (0 삽입)
                        bridge.offer(0);
                        time++;
                    }
                }
            }
        }

        // 마지막 트럭이 완전히 다리를 건너야 하므로 bridge_length 더함
        return time + bridge_length;
    }
}