import java.util.*;

class Solution {
    
    // 전역 변수로 선언하여 재귀 호출 간에 상태를 공유
    int N;
    int[][] D;
    int maxWinCount = -1; // 초기값을 -1로 설정하여 어떤 승리 횟수라도 갱신되도록 함
    int[] bestCombination;

    public int[] solution(int[][] dice) {
        N = dice.length;
        D = dice;
        
        // A가 선택할 주사위 조합을 저장할 배열, N/2개의 주사위를 선택
        int[] aCombination = new int[N / 2];

        // A가 선택할 주사위 조합을 찾는 재귀 함수 호출
        // 0번 주사위부터 시작, 현재까지 선택된 주사위는 0개
        findCombinations(0, 0, aCombination);

        // 1-based index로 변환
        int[] result = new int[N / 2];
        for (int i = 0; i < N / 2; i++) {
            result[i] = bestCombination[i] + 1;
        }

        return result;
    }
    
    // A가 가질 주사위 조합을 찾는 재귀 함수 (조합)
    void findCombinations(int start, int count, int[] aCombination) {
        // A가 N/2개의 주사위를 모두 선택한 경우
        if (count == N / 2) {
            // A와 B의 주사위 조합으로 승패 계산 시작
            simulate(aCombination);
            return;
        }
        
        // N개의 주사위 중 N/2개를 선택하는 조합
        for (int i = start; i < N; i++) {
            aCombination[count] = i;
            findCombinations(i + 1, count + 1, aCombination);
        }
    }

    // A와 B의 주사위 조합으로 승패를 시뮬레이션하는 함수
    void simulate(int[] aCombination) {
        // B의 주사위 조합을 찾기
        List<Integer> bIndices = new ArrayList<>();
        boolean[] isASelected = new boolean[N];
        for (int index : aCombination) {
            isASelected[index] = true;
        }
        for (int i = 0; i < N; i++) {
            if (!isASelected[i]) {
                bIndices.add(i);
            }
        }
        int[] bCombination = bIndices.stream().mapToInt(i -> i).toArray();

        // 각 조합에서 나올 수 있는 모든 주사위 눈금의 합을 구함 (DFS)
        List<Integer> aSums = new ArrayList<>();
        getDiceSums(aCombination, 0, 0, aSums);

        List<Integer> bSums = new ArrayList<>();
        getDiceSums(bCombination, 0, 0, bSums);

        // B의 눈금 합을 정렬하여 이분 탐색 준비
        Collections.sort(bSums);
        
        int currentWinCount = 0;
        // A의 모든 합에 대해 B의 합과 비교하여 승리 횟수 계산
        for (int aSum : aSums) {
            // 이분 탐색을 통해 aSum보다 작은 B의 합 개수를 찾음
            int win = findWinCount(bSums, aSum);
            currentWinCount += win;
        }
        
        // 현재 조합의 승리 횟수가 최대 승리 횟수보다 크면 갱신
        if (currentWinCount > maxWinCount) {
            maxWinCount = currentWinCount;
            // 현재 A의 조합을 깊은 복사하여 저장
            bestCombination = Arrays.copyOf(aCombination, N / 2);
        }
    }
    
    // 주사위 눈금의 모든 합을 구하는 DFS 함수
    void getDiceSums(int[] combination, int depth, int sum, List<Integer> sums) {
        if (depth == combination.length) {
            sums.add(sum);
            return;
        }
        
        // 현재 주사위의 모든 눈금에 대해 재귀 호출
        for (int diceValue : D[combination[depth]]) {
            getDiceSums(combination, depth + 1, sum + diceValue, sums);
        }
    }
    
    // 이분 탐색으로 승리 횟수를 찾는 함수
    int findWinCount(List<Integer> sums, int target) {
        int left = 0;
        int right = sums.size() - 1;
        int count = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sums.get(mid) < target) {
                count = mid + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return count;
    }
}