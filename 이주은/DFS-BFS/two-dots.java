//BOJ 16929번 Two Dots (https://www.acmicpc.net/submit/16929/77333868)

import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static boolean answer = false;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        input();

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(answer)
                    break;
                
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i, j, i, j, map[i][j], 0);
                    visited[i][j] = false;
                }
                   
            }
        }
        
        if(answer)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    static void dfs(int i, int j, int I, int J, char color, int cnt) {
        if(answer)
            return;

        for(int k=0; k<4; k++) {
            int nextX = i+dx[k];
            int nextY = j+dy[k];

            if(nextX < 0 ||nextX >= N || nextY < 0 || nextY >= M);
            else if(color != map[nextX][nextY]);

            else if(!visited[nextX][nextY]){
                visited[nextX][nextY] = true;
                dfs(nextX, nextY, I, J, color, cnt+1);
                visited[nextX][nextY] = false;
            }

            else if(nextX == I && nextY == J && cnt >= 3) {
                answer = true;
                return;
            }
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        
        map = new char[N][M];
        visited = new boolean[N][M];
        
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        br.close();
    }
}
