import java.util.*;
import java.io.*;

// 7579 앱

class Main {

    static final int MAX_COST = 10000;
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dp = new int[MAX_COST+1]; // dp[i]: 비용 i를 사용하여 만들 수 있는 최대 메모리
        int[] memories = new int[N];
        int[] costs = new int[N];
        Arrays.fill(dp, -1);
        st = new StringTokenizer(bf.readLine());
        for (int i=0; i<N; i++) {
            memories[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for (int i=0; i<N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }
        for (int i=0; i<N; i++) {
            for (int j=MAX_COST; j>=costs[i]; j--) {
                if (dp[j-costs[i]] != -1)
                    dp[j] = Math.max(dp[j], dp[j-costs[i]]+memories[i]);
            }
            dp[costs[i]] = Math.max(dp[costs[i]], memories[i]);
        }

        for (int i=0; i<=MAX_COST; i++) {
            if (dp[i]>=M) {
                System.out.println(i);
                break;
            }
        }
    }
}
