package Algorithm.day_0708;

import java.io.FileInputStream;
import java.util.Scanner;

class Swea1486 {
    static int n;
    static int b;
    static int min;
    static int[] height;
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("src/day_0708/input_1486.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = sc.nextInt();
            b = sc.nextInt();
            height = new int[n];
            // 여기서 초기화 해주어야 매 test_case마다 초기화 된다.
            min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                height[i] = sc.nextInt();
            }
            dfs(0, 0);
            System.out.println("#" + test_case + " " + min);
        }
    }

    private static void dfs(int level, int sum) {
        if(level == n) {
            if(sum >= b) {
                min = Math.min(min, sum - b);
            }
            return;
        }
        dfs(level + 1, sum + height[level]);
        dfs(level + 1, sum);
    }
}
