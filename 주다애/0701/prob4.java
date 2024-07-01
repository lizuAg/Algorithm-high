import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon2146 {
    static int n;
    static int map[][];
    static boolean[][] visited;
    static int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];
        // 입력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int num = 2;
        // 1. 각 섬에 번호 붙여서 구분해주기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    getIsland(i, j, num);
                    num++;
                }
            }
        }
        // 2. 최솟값 구하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) {
                    bfs(i, j, map[i][j]);
                }
            }
        }
        System.out.println(min);
    }

    private static void bfs(int r, int c, int num) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c, 0});
        boolean[][] checked = new boolean[n][n];
        checked[r][c] = true;
        while (!q.isEmpty()) {
            int[] target = q.poll();
            int cx = target[0];
            int cy = target[1];
            int cnt = target[2];
            if(map[cx][cy] != 0 && map[cx][cy] != num) min = Math.min(min, cnt - 1);
            if(cnt > min) return; // 탐색 필요 없음
            for (int i = 0; i < 4; i++) {
                int nx = cx + dir[i][0];
                int ny = cy + dir[i][1];
                if(!canMove(nx, ny)) continue;
                if(map[nx][ny] == num) continue;
                if(checked[nx][ny]) continue;
                q.offer(new int[]{nx, ny, cnt + 1});
                checked[nx][ny] = true;
            }
        }
    }

    private static void getIsland(int r, int c, int num) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        map[r][c] = num;
        visited[r][c] = true;
        while (!q.isEmpty()) {
            int[] target = q.poll();
            int cx = target[0];
            int cy = target[1];
            for (int i = 0 ; i < 4; i++) {
                int nx = cx + dir[i][0];
                int ny = cy + dir[i][1];
                if(!canMove(nx, ny)) continue;
                if(map[nx][ny] == 1 && !visited[nx][ny]) {
                    q.offer(new int[]{nx,ny});
                    map[nx][ny] = num;
                    visited[nx][ny] = true;
                }
            }
        }
    }

    static boolean canMove(int r, int c) {
        if(r < 0 || r >= n || c < 0 || c >= n) return false;
        return true;
    }
}
