//백준 2206번 벽 부수고 이동하기 (https://www.acmicpc.net/submit/2206/78040981)

import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static boolean[][] map;
    static int[][][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        input();

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 0, 1});
        visited[0][0][0] = 1;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            for(int i=0; i<4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                int cnt = now[2];
                int cost = now[3] + 1;

                if(x < 0 || x >= N || y < 0 || y >= M);
                else if(!map[x][y] && (visited[x][y][cnt] == 0 || cost < visited[x][y][cnt])){
                    queue.add(new int[] {x, y, cnt, cost});
                    visited[x][y][cnt] = cost;
                }
                else if (cnt != 1 && (visited[x][y][1] == 0 || cost < visited[x][y][1])) {
                    queue.add(new int[] {x, y, 1, cost});
                    visited[x][y][1] = cost;
                }
            }
        }

        int no = visited[N-1][M-1][0];
        int yes = visited[N-1][M-1][1];
        int answer;
        if(no == 0 && yes == 0)
            answer = -1;
        else if(no == 0)
            answer = yes;
        else if(yes == 0)
            answer = no;
        else
            answer = Math.min(no, yes);

        System.out.println(answer);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        map = new boolean[N][M];
        visited = new int[N][M][2];

        for(int i=0; i<N; i++) {
            line = br.readLine().split("");
            for(int j=0; j<M; j++) {
                map[i][j] = line[j].equals("1");
            }
        }
    }
}
