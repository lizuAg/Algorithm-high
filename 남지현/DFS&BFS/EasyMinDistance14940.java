import java.util.*;
import java.io.*;

// 백준 14940 실버1 - 쉬운 최단거리

class Main {
    
    static int[][] board, dist;
    static int n, m, x, y;

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    private static void solution() {
        // bfs -> 도착지에서 시작
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.addFirst(new int[]{x, y, 0});
        while (!queue.isEmpty()) {
            int[] now = queue.pollLast();
            x = now[0];
            y = now[1];
            for (int i=0; i<4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if (nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny]==1 && dist[nx][ny]==-1) {
                    queue.addFirst(new int[]{nx, ny, now[2]+1});
                    dist[nx][ny] = now[2]+1;
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        dist = new int[n][m];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j]==2) {
                    x = i;
                    y = j;
                    dist[i][j]=0;
                } else if (board[i][j]==0) {
                    dist[i][j]=0;
                } else {
                    dist[i][j] = -1;
                }
            }
        }
        solution();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
