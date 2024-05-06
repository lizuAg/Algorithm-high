import java.util.Scanner;

// 2Xn 타일링 2(실버 3)
public class BaekJoon11727 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] dp = new int[n + 1];
        // n = 1일 때 처리
        if(n == 1) {
            System.out.println(1);
            return;
        }
        dp[1] = 1;
        dp[2] = 3;

        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        }

        System.out.println(dp[n]);
    }
}
