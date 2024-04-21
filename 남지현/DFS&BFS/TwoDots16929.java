import java.util.*;
import java.io.*;

// Two Dots - DFS를 사용한 풀이
class Main {

    static int N;
    static int M;
    static boolean hasCycle = false;
    static String[][] board;
    static boolean[][] visited;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    private static void dfs(int x, int y, int lastX, int lastY) {
        for (int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if (nx>=0 && nx<N && ny>=0 && ny<M && board[nx][ny].equals(board[x][y])) {
                if (!visited[nx][ny]){
                    visited[nx][ny] = true;
                    dfs(nx, ny, x, y);
                } else if (lastX!=nx || lastY!=ny) {
                    hasCycle = true;
                    return;
                }
            }
        }
        return;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        board = new String[N][M];
        for (int i=0; i<N; i++) {
            board[i] = bf.readLine().split("");
        }
        
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i, j, -1, -1);
                    if (hasCycle) {
                        System.out.println("Yes");
                        return;
                    }
                }
            }
        }
        System.out.println("No");
    }
}
