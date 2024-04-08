import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 아기 상어2(실버 2)
public class BaekJoon17086 {
    static int N;
    static int M;
    static int[][] babyShark;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        babyShark = new int[N][M];
        map = new int[N][M];
        visited = new boolean[N][M];
        // 입력
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < M; j++) {
                babyShark[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(babyShark[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, 0);
                }
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] >= max) {
                    max = map[i][j];
                }
            }
        }
        System.out.println(max);
    }

    private static void bfs(int x, int y, int dis) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        q.offer(new int[]{x, y, dis});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] t = q.poll();
            int cx = t[0];
            int cy = t[1];
            int cd = t[2];
            for(int[] d : dir) {
                int nx = cx + d[0];
                int ny = cy + d[1];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if(babyShark[nx][ny] == 0 && !visited[nx][ny]) {
                        q.offer(new int[]{nx, ny, cd + 1});
                        if(map[nx][ny] == 0) map[nx][ny] = cd + 1;
                        if(map[nx][ny] != 0 && map[nx][ny] >= cd + 1) {
                            map[nx][ny] = cd + 1;
                        }
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        visited = new boolean[N][M];
    }
}
