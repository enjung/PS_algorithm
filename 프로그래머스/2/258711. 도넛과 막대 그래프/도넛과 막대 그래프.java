import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        // [0]: 생성 정점 번호, [1]: 도넛 그래프 수, [2]: 막대 그래프 수, [3]: 8자 그래프 수
        int[] answer = new int[4];
        
        // 정점의 최대 번호를 찾기 위한 변수
        int maxVertex = 0;
        for (int[] edge : edges) {
            maxVertex = Math.max(maxVertex, Math.max(edge[0], edge[1]));
        }

        // 정점의 in-degree와 out-degree를 저장할 배열
        int[] inDegree = new int[maxVertex + 1];
        int[] outDegree = new int[maxVertex + 1];

        // 1. 모든 간선을 순회하며 in-degree와 out-degree 계산
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            outDegree[from]++;
            inDegree[to]++;
        }

        // 2. 생성 정점(generatedVertex) 찾기
        // in-degree는 0이고 out-degree는 2 이상인 정점
        int generatedVertex = 0;
        for (int i = 1; i <= maxVertex; i++) {
            if (inDegree[i] == 0 && outDegree[i] >= 2) {
                generatedVertex = i;
                break;
            }
        }
        answer[0] = generatedVertex;

        // 3. 생성 정점에서 나가는 간선들을 제외하여 각 그래프의 종류 파악
        int totalGraphCount = outDegree[generatedVertex];
        int stickCount = 0;
        int eightCount = 0;
        
        for (int i = 1; i <= maxVertex; i++) {
            // 생성 정점은 제외
            if (i == generatedVertex) {
                continue;
            }
            
            // 그래프의 정점인지 확인 (inDegree 또는 outDegree가 0이 아니어야 함)
            // 고립된 정점(in=0, out=0)은 카운트하지 않음.
            if (inDegree[i] == 0 && outDegree[i] == 0) {
                continue;
            }

            // 막대 그래프: out-degree가 0인 정점은 막대 그래프의 끝점
            if (outDegree[i] == 0) {
                stickCount++;
            }
            // 8자 그래프: in-degree와 out-degree가 모두 2 이상인 정점은 8자 그래프의 교차점
            else if (inDegree[i] >= 2 && outDegree[i] >= 2) {
                eightCount++;
            }
        }

        // 4. 도넛 그래프 개수 계산
        int donutCount = totalGraphCount - stickCount - eightCount;

        answer[1] = donutCount;
        answer[2] = stickCount;
        answer[3] = eightCount;

        return answer;
    }
}