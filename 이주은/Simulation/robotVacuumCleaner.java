import java.util.*;
import java.io.*;

class Main {
    static int answer = 0;
    
    static int N, M;
    static int[][] map; //0빈칸 1벽 2청소

    static int[] dx = {-1, 0, 1, 0}; //0북 1동 2남 3서
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        line = br.readLine().split(" ");
        int x = Integer.parseInt(line[0]);
        int y = Integer.parseInt(line[1]);
        int dir = Integer.parseInt(line[2]);

        map = new int[N][M];
        
        for(int i=0; i<N; i++) {
            line = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        run(x, y, dir);

        System.out.println(answer);
    }

    public static void run(int x, int y, int dir) {
        if(map[x][y] == 0) {
            map[x][y] = 2;
            answer ++;
        }
        
        for(int i=1; i<5; i++) {
            int tempDir = (dir + i) % 4;
            int nextX = x + dx[tempDir];
            int nextY = y + dy[tempDir];
            
            if(nextX<0 || nextX >=N || nextY<0 || nextY >= M);
            else if(map[nextX][nextY] == 0) {
                run(nextX, nextY, tempDir);
                return;
            }
        }

        int tempDir = (dir + 2) % 4;
        int nextX = x + dx[tempDir];
        int nextY = y + dy[tempDir];
        
        if(nextX<0 || nextX >=N || nextY<0 || nextY >= M);
        else if(map[nextX][nextY] != 1) {
                run(nextX, nextY, dir);
        }
    }
}
