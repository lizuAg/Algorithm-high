import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 로봇 조종하기(골드 2)
/*
    1. backTracking: 메모리 초과 -> 좌표 담는 list 삭제 -> 시간 초과
     --> O(3^(N * M))의 시간 복잡도(3방향)
*/
/*
    2. DP로 풀자 --> O(N * M)의 시간 복잡도
*/
public class BaekJoon2169 {
    static int N;
    static int M;
    static int[][] nasa;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}};
    static boolean[][] used;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nasa = new int[N][M];
        used = new boolean[N][M];
        // 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                nasa[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        run(0, 0, nasa[0][0]);
        int[][] dp = new int[N][M];
        dp[0][0] = nasa[0][0];
        // 맨 윗 줄은 오른쪽으로만 이동 가능
        for(int i = 1; i < M; i++) {
            dp[0][i] = dp[0][i - 1] + nasa[0][i];
        }
        int[][] temp = new int[2][M];
        for (int i = 1; i < N; i++) {

            temp[0][0] = dp[i - 1][0] + nasa[i][0];
            for (int j = 1; j < M; j++) {
                // 왼쪽에서 오는지 or 위에서 오는지
                temp[0][j] = Math.max(temp[0][j - 1], dp[i - 1][j]) + nasa[i][j];
            }
            temp[1][M - 1] = dp[i - 1][M - 1] + nasa[i][M - 1];
            for (int j = M - 2; j >= 0; j--) {
                // 오른쪽에서 오는지 or 위에서 오는지
                temp[1][j] = Math.max(temp[1][j + 1], dp[i - 1][j]) + nasa[i][j];
            }
            for (int j = 0; j < M; j++) {
                // 둘 중 더 큰 값 dp 배열에 저장
                dp[i][j] = Math.max(temp[0][j], temp[1][j]);
            }
        }
        System.out.println(dp[N - 1][M - 1]);
    }

//    private static void run(int r, int c, int sum) {
//        if(r == N - 1 && c == M - 1) {
//            max = Math.max(max, sum);
//            return;
//        }
//
//        for(int i = 0; i < 3; i++) {
//            if(!canMove(r + dir[i][0], c + dir[i][1]) || used[r + dir[i][0]][c + dir[i][1]]) continue;
//            used[r + dir[i][0]][c + dir[i][1]] = true;
//            run(r + dir[i][0], c + dir[i][1], sum + nasa[r + dir[i][0]][c + dir[i][1]]);
//            used[r + dir[i][0]][c + dir[i][1]] = false;
//        }
//    }

//    private static boolean canMove(int r, int c) {
//        if(r < 0 || r >= N || c < 0 || c >= M) return false;
//        return true;
//    }
}
