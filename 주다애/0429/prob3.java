import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 퇴사 2(골드 5)
public class BaekJoon15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // day
        int[] T = new int[n + 1];
        // 걸리는 시간
        int[] P = new int[n + 1];
        StringTokenizer st;
        for(int i = 1; i <=n; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        int res = dp(n, T, P);
        System.out.println(res);
    }

    private static int dp(int n, int[] T, int[] P) {
        int[] dpArr = new int[n + 2];
        // i일에 상담 -> i + t[i]까지 상담 못함 / p[i] 수익 얻음 -> dp[i] = dp[i+t[i]] + p[i]
        // i일에 상담 X -> dp[i + 1]

        for(int i = n; i >= 0; i--) {
            // 상담 끝나는 다음날
            int next = i + T[i];

            // 다음날까지 상담이 가능하면
            if(next <= n + 1) {
                dpArr[i] = Math.max(dpArr[i + 1], dpArr[i + T[i]] + P[i]);
            }
            else {
                dpArr[i] = dpArr[i + 1];
            }
        }
        return dpArr[0];
    }
}
