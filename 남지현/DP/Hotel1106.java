import java.util.*;
import java.io.*;

// 호텔 1106

class Main {

    static final int MAX = 100001;
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] dp = new int[C+100];
        Arrays.fill(dp, MAX);
        dp[0]=0;
        for (int n=0; n<N; n++) {
            st = new StringTokenizer(bf.readLine());
            int cost = Integer.parseInt(st.nextToken()); 
            int customer = Integer.parseInt(st.nextToken());
            for (int i=customer; i<C+100; i++) {
                if (dp[i-customer] < MAX) {
                    dp[i] = Math.min(dp[i], dp[i-customer]+cost);
                }
            }
        }
        int answer = MAX;
        for (int i=C; i<C+100; i++) {
            answer = Math.min(answer, dp[i]);
        }
        System.out.println(answer);
        bf.close();
    }
}
