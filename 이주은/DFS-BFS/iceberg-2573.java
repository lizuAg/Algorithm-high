//백준 2573번 빙산(https://www.acmicpc.net/submit/2573/78950399)

import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] map;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        getInput();
        System.out.println(solve());

    }

    static int solve() {
        int year = 0;
        boolean flag = false;
        
        do {            
            flag = false;
            boolean[][] visited = new boolean[N][M];
        
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(map[i][j] <= 0);
                    else if(!visited[i][j] && flag)
                        return year;
                    else if(!visited[i][j]){
                        visited[i][j] = true;
                        dfs(visited, i, j);
                        flag = true;
                    }
                }
            }
            year++;
        } while(flag);

        return 0;
    }

    static void dfs(boolean[][] visited, int r, int c) {
        int cnt = 0;
        
        for(int i=0; i<4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M);
            else if(map[nr][nc] <= 0)
                cnt++;
        }

        for(int i=0; i<4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M);
            else if(map[nr][nc] > 0 && !visited[nr][nc]) {
                visited[nr][nc] = true;
                dfs(visited, nr, nc);
            }
        }
        map[r][c] -= cnt;
    }

    static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            line = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
    }
}
