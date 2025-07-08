import java.util.*;

class Solution {
    Set<Integer> numbersSet = new HashSet<>();

    public int solution(String numbers) {
        for (int len = 1; len <= numbers.length(); len++) {
            permutation(numbers, "", len, new boolean[numbers.length()]);
        }

        int count = 0;
        for (int num : numbersSet) {
            if (isPrime(num)) count++;
        }

        return count;
    }

    // 순열 생성 함수 (백트래킹 방식)
    public void permutation(String numbers, String current, int targetLength, boolean[] visited) {
        if (current.length() == targetLength) {
            numbersSet.add(Integer.parseInt(current));
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(numbers, current + numbers.charAt(i), targetLength, visited);
                visited[i] = false; // 백트래킹
            }
        }
    }

    // 소수 판별 함수
    public boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}