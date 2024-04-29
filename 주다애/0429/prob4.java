import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 파이프 옮기기 1(골드 5)
public class Main {
    static int[][] map;
    static int n;
    static int[][][] dir = {
            {{0,1}, {0, 0}, {0,0}},
            {{1,1}, {-1,0}, {0,-1}},
            {{1,0}, {0,0}, {0,0}},
    }; // (이동, 빈칸, 빈칸) 가로,대각선,세로
    static int cnt;
    static int[] path = {0, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        StringTokenizer st;
        // 입력
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 못 움직임
        if(map[0][2] == 1) {
            System.out.println(0);
            return;
        }
        dfs(0, 1, 0);
        System.out.println(cnt);
    }

    private static void dfs(int r, int c, int d) {
        if(r == n - 1 && c == n - 1) {
            cnt++;
            return;
        }
        switch (d) {
            // 가로
            case 0:
                for(int i = 0; i <= 1; i++) {
                    int nr = r + dir[i][0][0];
                    int nc = c + dir[i][0][1];
                    if(canMove(nr, nc) && canMovePipe(nr, nc, dir[i])) dfs(nr, nc, i);
                }
                break;
            // 대각선
            case 1:
                for(int i = 0; i <= 2; i++) {
                    int nr = r + dir[i][0][0];
                    int nc = c + dir[i][0][1];
                    if(canMove(nr, nc) && canMovePipe(nr, nc, dir[i])) dfs(nr, nc, i);
                }
                break;
            // 세로
            case 2:
                for(int i = 1; i <= 2; i++) {
                    int nr = r + dir[i][0][0];
                    int nc = c + dir[i][0][1];
                    if(canMove(nr, nc) && canMovePipe(nr, nc, dir[i])) dfs(nr, nc, i);
                }
                break;
        }
    }

    static boolean canMovePipe(int r, int c, int[][] nd) {
        if(map[r + nd[1][0]][c + nd[1][1]] == 0 && map[r + nd[2][0]][c + nd[2][1]] == 0) {
            return true;
        }
        return false;
    }

    static boolean canMove(int r, int c) {
        if(r >= 0 && r < n && c >= 0 && c < n && map[r][c] == 0) return true;
        return false;
    }
}
