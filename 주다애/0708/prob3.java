package Algorithm.day_0708;

import java.util.Scanner;

// 파리퇴치3
// 중심 포함 m칸!
public class Swea12712 {
    static int n;
    static int m;
    static int[][] map;
    public static void main(String args[]) throws Exception
    {
        //System.setIn(new FileInputStream("src/input_12712.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = sc.nextInt();
            m = sc.nextInt();
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            int max = 0;
            int v = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    max = Math.max(Math.max(xShape(i, j) + map[i][j], plusShape(i, j) + map[i][j]), max);
                }
            }
            System.out.println("#" + test_case + " " + max);
        }
    }

    private static int plusShape(int r, int c) {
        int cSum = 0;
        // 가로
        for (int i = c - m + 1; i < c + m; i++) {
            if(i < 0 || i >= n) continue;
            if(i == c) continue;
            cSum += map[r][i];
        }
        int rSum = 0;
        // 세로
        for (int i = r - m + 1; i < r + m; i++) {
            if(i < 0 || i >= n) continue;
            if(i == r) continue;
            rSum += map[i][c];
        }
        return rSum + cSum;
    }

    private static int xShape(int r, int c) {
        int downRightSum = 0;
        for (int i = 1; i < m; i++) {
            if(r + i < n && c + i < n) downRightSum += map[r + i][c + i];
            if(r - i >= 0 && c - i >= 0) downRightSum += map[r - i][c - i];
        }
        int downLeftSum = 0;
        for (int i = 1; i < m; i++) {
            if(r + i < n && c - i >= 0) downLeftSum += map[r + i][c - i];
            if(r - i >= 0 && c + i < n) downLeftSum += map[r - i][c + i];
        }
        return downRightSum + downLeftSum;
    }
}
