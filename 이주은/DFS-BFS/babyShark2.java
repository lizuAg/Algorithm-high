//BOJ 17086 아기상어2 (https://www.acmicpc.net/submit/17086/76338252)

import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] map;
    static List<int[]> sharks = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    
    public static void main(String[] args) throws IOException {
        int answer = 0;
        input();

        for(int[] shark : sharks) {
            int temp = getSafeDistance(shark[0], shark[1]);
            answer = Math.max(temp, answer);
        }

        System.out.println(answer);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                
                if(map[i][j] != 1)
                    sharks.add(new int[] {i, j});
            }
        }
    }

    static int getSafeDistance(int startX, int startY) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[] {startX, startY, 0});
        visited[startX][startY] = true;
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            for(int i=0; i<8; i++) {
                int x = curr[0] + dx[i];
                int y = curr[1] + dy[i];
                int d = curr[2] + 1;

                if(x<0 || x>=N || y<0 || y>=M)
                    continue;
                if(visited[x][y])
                     continue;
                
                if(map[x][y] == 1)
                   return d;
                
                queue.add(new int[] {x, y, d});
                visited[x][y] = true;
            }
        }
        return -1;
    }
}
