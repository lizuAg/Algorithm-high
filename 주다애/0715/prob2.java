import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 쉬운 최단거리(실버 1)
public class BaekJoon14940 {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int[][] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        ans = new int[n][m];
        // 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // bfs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 2) {
                    bfs(i, j, 0);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 도달할 수 없는 위치
                if(map[i][j] == 1 && !visited[i][j]) {
                    System.out.print(-1 + " ");
                    continue;
                }
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int r, int c, int cnt) {
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c, cnt});
        visited[r][c] = true;
        ans[r][c] = 0;
        while (!q.isEmpty()) {
            int[] t = q.poll();
            for (int[] d : dir) {
                int nr = t[0] + d[0];
                int nc = t[1] + d[1];
                if(!canMove(nr, nc)) continue;
                if(map[nr][nc] == 1 && !visited[nr][nc]) {
                    q.offer(new int[]{nr, nc, t[2] + 1});
                    visited[nr][nc] = true;
                    ans[nr][nc] = t[2] + 1;
                }
            }
        }
    }

    private static boolean canMove(int r, int c) {
        if(r < 0 || r >= n || c < 0 || c >= m) return false;
        return true;
    }
}
