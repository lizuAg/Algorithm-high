import java.util.*;
import java.io.*;

// SWEA 12712 파리퇴치3

class Main {

    static int N, M;
    static int[][] board;

    static final int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static final int[] dy = {0, 0, -1, 1, -1, 1, -1 ,1};

    private static int solution() {
        int max = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                int sum = board[i][j];
                for (int d=0; d<4; d++) {
                    // 십자 모양
                    int count=1;
                    int nx = i+dx[d];
                    int ny = j+dy[d];
                    while (canMoveTo(nx, ny) && count<M) {
                        sum += board[nx][ny];
                        nx += dx[d];
                        ny += dy[d];
                        count++;
                    }
                }
                max = Math.max(max, sum);
                sum = board[i][j];
                for (int d=4; d<8; d++) {
                    // 가위 모양
                    int count=1;
                    int nx = i+dx[d];
                    int ny = j+dy[d];
                    while (canMoveTo(nx, ny) && count<M) {
                        sum += board[nx][ny];
                        nx += dx[d];
                        ny += dy[d];
                        count++;
                    }
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    private static boolean canMoveTo(int x, int y) {
        return x>=0 && x<N && y>=0 && y<N;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int test_case=1; test_case<=T; test_case++) {
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            board = new int[N][N];
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j=0; j<N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("#").append(test_case).append(" ").append(solution()).append("\n");
        }
        System.out.print(sb);
    }
}
