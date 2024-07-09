import java.util.*;
import java.io.*;

// 4193. 수영대회 결승전

class Main {

    static int N, A, B, C, D;
    static int[][] sea;
    static boolean[][] visited;

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static class Point {
        int x;
        int y;
        int depth;

        Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    private static int solution() {
        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.addLast(new Point(A, B, 0));
        visited[A][B]=true;
        while(!queue.isEmpty()) {
            Point now = queue.pollFirst();
            for (int i=0; i<4; i++) {
                int nextX = now.x+dx[i];
                int nextY = now.y+dy[i];
                if (nextX<0 || nextX>=N || nextY<0 || nextY>=N) continue;
                if (nextX==C && nextY==D) {
                    return now.depth+1;
                }
                if (sea[nextX][nextY]==1 || visited[nextX][nextY]) continue;
                if (sea[nextX][nextY]==2) {
                    if (now.depth%3==2) {
                        visited[nextX][nextY]=true;
                        queue.addLast(new Point(nextX, nextY, now.depth+1));
                    } else {
                        visited[now.x][now.y]=true;
                        queue.addLast(new Point(now.x, now.y, now.depth+1));
                    }
                } else {
                    visited[nextX][nextY]=true;
                    queue.addLast(new Point(nextX, nextY, now.depth+1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int test_case=1; test_case<=T; test_case++) {
            N = Integer.parseInt(bf.readLine());
            sea = new int[N][N];
            visited = new boolean[N][N];
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j=0; j<N; j++) {
                    sea[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            st = new StringTokenizer(bf.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bf.readLine());
            C = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            sb.append("#").append(test_case).append(" ").append(solution()).append("\n");
        }
        System.out.print(sb);
    }
}
