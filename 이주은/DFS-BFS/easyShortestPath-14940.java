//백준 14940번 쉬운최단거리

import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    static Queue<int[]> queue = new LinkedList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        getInput();

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            map[curr[0]][curr[1]] = curr[2];
          
            for(int i=0; i<4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
               
                if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                    
                if(visited[nx][ny])
                    continue;
                
                visited[nx][ny] = true;
                queue.add(new int[] {nx, ny, curr[2]+1});
            }
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!visited[i][j] && map[i][j] == 0)
                    bw.write("-1 ");
                else
                    bw.write(map[i][j]+" ");
            }
            bw.write("\n");
        }
        
        bw.flush();
    }

    static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        map = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i=0; i<N; i++) {
            line = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                if(line[j].equals("1")){
                    continue;
                }
                else if(line[j].equals("0")){
                    map[i][j] = 0;
                    visited[i][j] = true;
                }
                else {
                    visited[i][j] = true;
                    queue.add(new int[] {i, j, 0});
                }
            }
        }
    }
}
