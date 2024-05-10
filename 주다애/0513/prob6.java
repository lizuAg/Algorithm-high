package Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 로봇 청소기(골드 5)
// 한 번 다녀간 곳에서 다시 탐색하지 않음
public class BaekJoon14503 {
    static int[][] map;
    static int[][] dir = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
    static boolean[][] visited;
    static int n;
    static int m;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        // 입력
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(r, c, d);
        System.out.println(ans);
    }

    private static void clean(int r, int c, int d) {
        boolean flag = false;
        // 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
        if(map[r][c] == 0) {
            map[r][c] = -1;
            ans++;
        }
        for(int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            // 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
            if(canMove(nr, nc) && map[nr][nc] == 0) {
                flag = true;
                break;
            }
        }
        if(flag) {
            clean(r + dir[d][0], c + dir[d][1], d);
            // 재귀가 끝나고 다시 돌아와서 탐색하는 것 방지하는 return
            return;
        }
        //2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
        if(!flag) {
            int dd = (d + 2) % 4;
            int nr = r + dir[dd][0];
            int nc = c + dir[dd][1];
            if(canMove(nr, nc)) {
                if(map[nr][nc] != 1) clean(nr, nc, d);
            }
        }
    }

    private static boolean canMove(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= m) return false;
        return true;
    }
}
