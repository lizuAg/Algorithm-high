package Algorithm.day_0708;

import java.util.Scanner;

// 뮤탈리스크(골드 4)
// 테케만 통과
// DP + 재귀
// 1. 시간초과 -> 재귀 횟수를 줄이자
// 2. 너무 어려워요
public class BaekJoon12869 {
    static int[][][] dp;
    static int[][] attack = {{-9,-3,-1},{-9,-1,-3},{-3,-9,-1},{-3,-1,-9},{-1,-9,-3},{-1,-3,-9}};
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scv = new int[3];
        for (int i = 0; i < n; i++) {
            scv[i] = sc.nextInt();
        }
        dp = new int[61][61][61];
        run(0, scv);
        System.out.println(min);
    }

    private static void run(int level, int[] now) {
        if(min <= level) return;
        if(dp[now[0]][now[1]][now[2]] != 0 && dp[now[0]][now[1]][now[2]] <= level) return;

        dp[now[0]][now[1]][now[2]] = level;
        // 종료 조건
        if(now[0] == 0 && now[1] == 0 && now[2] == 0) {
            min = Math.min(level, min);
            return;
        }

        for(int i = 0; i < 6; i++) {
            // 음수는 0으로 만들어줌(dp 배열에 저장해야하므로)
            run(level + 1, new int[]{Math.max(now[0] + attack[i][0], 0),
                    Math.max(now[1] + attack[i][1], 0), Math.max(now[2] + attack[i][2], 0)});

        }
    }
}
