import java.util.*;

class Solution {
    Set<Integer> numbersSet = new HashSet<>();
    public int solution(String numbers) {
        int cnt=0;
        for (int i = 1; i <= numbers.length(); i++) {
            boolean[] visited = new boolean[numbers.length()];
            permutation(numbers, "", i, visited); //길이 i인 순열 만들기
        }

        for (int num : numbersSet) {
            if (isPrime(num)) {
               cnt++;
            }
        }
        return cnt;
    }
    
    //순열 만들기
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
    
    
    //소수판별, 끝까지 안돌고 제곱근까지만 돌아도 소수판별가능!
    public boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}