import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 퇴사(실버 3)
// 지현님 코드 참고
public class BaekJoon14501 {
    static int[] t;
    static int[] p;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        t = new int[N + 1];
        p = new int[N + 1];
        StringTokenizer st;
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        int res = dp();
        System.out.println(res);
    }

    private static int dp() {
        int[] dpArr = new int[N + 2];
        // i일에 상담 -> i + t[i]까지 상담 못함 / p[i] 수익 얻음 -> dp[i] = dp[i+t[i]] + p[i]
        // i일에 상담 X -> dp[i + 1]

        for(int i = N; i >= 0; i--) {
            // 상담 끝나는 다음날
            int next = i + t[i];
            // 다음날까지 상담이 가능하면
            if(next <= N + 1) {
                dpArr[i] = Math.max(dpArr[i + 1], dpArr[i + t[i]] + p[i]);
            }
            else {
                dpArr[i] = dpArr[i + 1];
            }
        }
        return dpArr[0];
    }
}
