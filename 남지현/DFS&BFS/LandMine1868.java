import java.util.*;
import java.io.*;

class Solution {

    static char[][] map;
    static boolean[][] visited;
    static int N;

    static final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    private static int countLandMines(int x, int y) {
        int count = 0;
        for(int k=0; k<8; k++) {
            int nx = x+dx[k];
            int ny = y+dy[k];
            if (nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny]=='*') count++;
        }
        return count;
    }

    private static void bfs(int x, int y) {
        ArrayDeque<char[]> queue = new ArrayDeque<>();
        queue.addLast(new char[]{(char)(x+'0'), (char)(y+'0')});
        visited[x][y] = true;
        while (! queue.isEmpty()) {
            char[] pt = queue.pollFirst();
            int i = pt[0]-'0';
            int j = pt[1]-'0';
            int count = countLandMines(i, j);
            map[i][j] = (char)(count+'0');
            if (count > 0) continue;
            for (int d=0; d<8; d++) {
                int nx = i+dx[d];
                int ny = j+dy[d];
                if (nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny] && map[nx][ny] != '*') {
                    queue.addLast(new char[]{(char)(nx+'0'), (char)(ny+'0')});
                    visited[nx][ny] = true;
                }
            }
        }
    }
    
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        
        for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(bf.readLine());
            map = new char[N][N];
            visited = new boolean[N][N];
            for (int i=0; i<N; i++) {
                String input = bf.readLine();
                for (int j=0; j<N; j++) {
                    map[i][j] = input.charAt(j);
                }
                
            }
            int answer = 0;
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (map[i][j]!='*' &&countLandMines(i, j)==0 && !visited[i][j]) {
                        answer++;
                        bfs(i, j);
                    }
                    
                }
            }
            
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (map[i][j] == '.') {
                        map[i][j] = (char)(countLandMines(i, j)+'0');
                        visited[i][j] = true;
                        answer++;
                    }
                }
            }
            StringBuilder builder = new StringBuilder();
            builder.append("#").append(test_case).append(" ").append(answer);
            System.out.println(builder.toString());
        }
        bf.close();
    }
}
