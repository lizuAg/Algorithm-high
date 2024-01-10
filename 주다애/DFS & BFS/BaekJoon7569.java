package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 배열 값을 1로 바꾸는게 아니라 전날 값 + 1 로 해주는 것이 중요했던 것 같습니다!
public class BaekJoon7569 {
    static int[][][] tomato;
    static int m;
    static int n;
    static int h;
    static Queue<Coor> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        tomato = new int[h][n][m];
        // 입력
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if(tomato[i][j][k] == 1) {
                        queue.offer(new Coor(i, j, k));
                    }
                }
            }
        }
        
        int answer = 0;
        bfs();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if(tomato[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    answer = Math.max(answer, tomato[i][j][k]);
                }
            }
        }
        System.out.println(answer - 1);
    }

    private static void bfs() {
        int[] dx = {0, 0, 1, -1, 0, 0};
        int[] dy = {0, 0, 0, 0, 1, -1};
        int[] dz = {1, -1, 0, 0, 0, 0};
        while(!queue.isEmpty()) {
            Coor coor = queue.poll();
            int cx = coor.getX();
            int cy = coor.getY();
            int cz = coor.getZ();
            for(int i = 0; i < 6; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nz = cz + dz[i];
                if(nx >= 0 && nx < h && ny >= 0 && ny < n && nz >= 0 && nz < m) {
                    if(tomato[nx][ny][nz] == 0) {
                        queue.offer(new Coor(nx, ny, nz));
                        // tomato 배열 값을 증가하는 전날 + 1로 바꿔주기
                        tomato[nx][ny][nz] = tomato[cx][cy][cz] + 1;
                    }
                }
            }
        }
    }

    static class Coor {
        int x;
        int y;
        int z;

        public Coor(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getZ() {
            return z;
        }
    }
}
