import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 테트리스 게임(골드 4)
public class Main {
    static int[][] map;
    static int n;
    // 총 13방향
    static int[][][] dir = {
            {{0,0},{0,1},{0,2},{0,3}},// ㅡ
            {{0,0},{1,0},{2,0},{3,0}},// ㅣ
            {{0,0},{0,1},{1,1},{1,2}},// ㄹ
            {{0,1},{1,1},{1,0},{2,0}},
            {{0,0},{0,1},{0,2},{1,2}}, // ㄱ
            {{0,1},{1,1},{2,1},{2,0}},
            {{0,0},{1,0},{1,1},{1,2}}, //
            {{0,0},{0,1},{1,0},{2,0}}, //
            {{0,0},{0,1},{0,2},{1,1}}, // ㅜ
            {{0,1},{1,1},{1,0},{2,1}}, // ㅓ(
            {{0,1},{1,0},{1,1},{1,2}}, // ㅗ
            {{0,0},{1,0},{2,0},{1,1}},// ㅏ
            {{0,0},{0,1},{1,0},{1,1}},// ㅁ
    };
    static int cnt = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while((n = Integer.parseInt(br.readLine().trim())) != 0) {
            map = new int[n][n];
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int max = Integer.MIN_VALUE; // 음수 고려
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    int k = dfs(i, j);
                    max = Math.max(max, k);
                }
            }
            System.out.println((cnt++) + ". " + max);
        }
    }

    private static int dfs(int x, int y) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 13; i++) {
            int res = 0;
            boolean flag = true;
            for(int[] d :dir[i]) {
                int nx = x + d[0];
                int ny = y + d[1];
                if(!canMove(nx, ny)) {
                    flag = false;
                    break;
                }
                else {
                    res += map[nx][ny];
                }
            }
            if(flag) {
                max = Math.max(max, res);
            }
        }
        return max;
    }

    private static boolean canMove(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= n) return false;
        return true;
    }
}
