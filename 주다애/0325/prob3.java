import java.util.Scanner;

// 2*N 타일링(실버 3)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int dp[] = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        if(N > 1) {
            dp[2] = 2;
            for(int i = 3; i <= N; i++) {
                dp[i] = (dp[i -1] + dp[i -2]) % 10007;
            }
        }
        System.out.println(dp[N]);
    }
}
