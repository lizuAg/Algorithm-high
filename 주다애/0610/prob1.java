import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 기타리스트(실버 1)
// DP 문제
public class BaekJoon1495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken()); // 시작 볼륨
        int m = Integer.parseInt(st.nextToken()); // 최대 볼륨
        int[] music = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        // 입력
        for(int i = 0; i < n; i++) {
            music[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][] dp = new boolean[n + 1][m + 1]; // dp[i][j] -> i번째 곡에서 볼륨 j를 설정할 수 있는지
        dp[0][s] = true;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                // 이전 곡에서 j를 설정할 수 있다면
                if(dp[i - 1][j]) {
                    if(j - music[i - 1] >= 0) dp[i][j - music[i - 1]] = true;
                    if(j + music[i - 1] <= m) dp[i][j + music[i - 1]] = true;
                }
            }
        }
        int ans = -1;
        for(int i = m; i >= 0; i--) {
            // 마지막 곡에서 탐색
            if(dp[n][i]) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}
