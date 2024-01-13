import java.util.*;

// 아이템 줍기
class Solution {
    boolean[][] visited = new boolean[202][202];
    boolean[][] board = new boolean[202][202];
    

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 지도 2배 해주기 --> 둘레가 아닌 좌표로 가는 것 방지
        for (int[] r : rectangle) {
            for (int i = r[1] * 2; i <= r[3] * 2; i++) {
                for (int j = r[0] * 2; j <= r[2] * 2; j++) {
                    // 새로운 지도인 board를 true로 만듦
                    board[j][i] = true;
                    // 사각형 내부이면 true로 만들어서 방문하지 못하게 함
                    if (i > r[1] * 2 && i < r[3] * 2 && j > r[0] * 2 && j < r[2] * 2) {
                        visited[j][i] = true;
                    }
                }
            }
        }
        // 사각형 *2 해줬기 때문에 결과는 2를 나눠주어야 함
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }

    int bfs(int x, int y, int tx, int ty) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0});
        visited[x][y] = true;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int result = cur[2];
            if (cur[0] == tx && cur[1] == ty) {
                return result;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx >= 0 && nx < 202 && ny >= 0 && ny < 202) {
                    if(!visited[nx][ny] && board[nx][ny]) {
                        q.offer(new int[]{nx, ny, result + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }
}
