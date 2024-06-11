import java.util.*;
import java.io.*;

class Main {

    static int[][] board;
    static int[][] zeros;
    static int N;
    static int M;

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    private static int countGroup() {
        boolean[][] visited = new boolean[N][M];
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int group=0;
        for (int i=1; i<N-1; i++) {
            for (int j=1; j<M-1; j++) {
                if (board[i][j]>0 && !visited[i][j]) {
                    stack.add(new int[]{i, j});
                    visited[i][j] = true;
                    while (!stack.isEmpty()) {
                        int[] point = stack.poll();
                        for (int d=0; d<4; d++) {
                            int nx = point[0]+dx[d];
                            int ny = point[1]+dy[d];
                            if (isValid(nx, ny) && !visited[nx][ny] && board[nx][ny]>0) {
                                stack.add(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                    group++;
                }
            }
        }
        return group;
    }

    private static boolean isValid(int x, int y) {
        return x>=0 && x<N && y>=0 && y<M;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j=0; j<M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int year=0;
        int group=0;
        while ((group = countGroup())<=1) {
            if (group == 0) {
                year=0;
                break;
            }
            zeros = new int[N][M];
            for (int i=1; i<N-1; i++) {
                for (int j=1; j<M-1; j++) {
                    int count=0;
                    for (int d=0; d<4; d++) {
                        int nx = i+dx[d];
                        int ny = j+dy[d];
                        if (isValid(nx, ny) && board[nx][ny]==0) {
                            count++;
                        }
                    }
                    zeros[i][j] = count;
                }
            }
            for (int i=1; i<N-1; i++) {
                for (int j=1; j<M-1; j++) {
                    if (board[i][j]!=0) {
                        int number = board[i][j]-zeros[i][j];
                        if (number<=0) board[i][j] = 0;
                        else board[i][j] = number;
                    }
                }
            }
            year++;
        }
        System.out.println(year);
    }
}
