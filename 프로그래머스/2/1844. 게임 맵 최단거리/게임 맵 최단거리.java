import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (0 <= nx && nx < n && 0 <= ny && ny < m && maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        int answer = maps[n-1][m-1];
        return answer == 1 ? -1 : answer;
    }
}
