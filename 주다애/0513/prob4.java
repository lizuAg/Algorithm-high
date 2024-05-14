package saffy;

import java.util.*;
import java.io.*;

// 1. dfs - stack over flow + Queue 사용 문제
// 2. ans for-loop 밖에서 값을 넣어서 계속 값 누적되었었음.. -> 무조건 for-loop 안에서 선언하기!
// 
public class Swea1868 {
	static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int ans;

    public static void main(String args[]) throws Exception {
    	System.setIn(new FileInputStream("src/saffy/input_1868.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            map = new char[N][N];
            visited = new boolean[N][N];
            ans = 0;

            for (int i = 0; i < N; i++) {
                String line = sc.next();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '.' && !visited[i][j] && isZero(i, j)) {
                        dfs(i, j);
                        ans++;
                    }
                }
            }

            // 남은 '.' 카운트 (클릭하지 않은 부분)
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '.' && !visited[i][j]) ans++;
                }
            }

            System.out.println("#" + test_case + " " + ans);
        }
        sc.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        int count = 0;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (canMove(nx, ny) && map[nx][ny] == '*') count++;
        }

        if (count == 0) {
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (canMove(nx, ny) && map[nx][ny] == '.' && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }

    static boolean isZero(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (canMove(nx, ny) && map[nx][ny] == '*') return false;
        }
        return true;
    }
    
    static boolean canMove(int r, int c) {
    	if(r < 0 || r >= N || c < 0 || c >= N) return false;
    	return true;
    }
}
