import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        // graph[a][b] = true → a가 b를 이김
        boolean[][] graph = new boolean[n + 1][n + 1];
        

        // 직접 이긴 관계 저장
        for (int[] result : results) {
            graph[result[0]][result[1]] = true;
        }

        // 플로이드-워셜: 간접 이긴 관계 채우기
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0; //선수 i에 대해서 알고있는 승/패 수 집계
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                // i가 이기거나, i가 진 경우
                if (graph[i][j] || graph[j][i]) {
                    count++;
                }
            }
            if (count == n - 1) {
                answer++;
            }
        }

        return answer;
    }
}
