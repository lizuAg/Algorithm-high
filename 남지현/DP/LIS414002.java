import java.util.*;
import java.io.*;

// 가장 긴 증가하는 부분 수열4

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<i; j++) {
                if (arr[i]>arr[j] && dp[i]<dp[j]) {
                    dp[i] = dp[j];
                }
            }
            dp[i]+=1;
            max = Math.max(max, dp[i]);
        }
        List<Integer> answer = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        builder.append(max).append("\n");
        int idx = N-1;
        while (max>=0 && idx>=0) {
            if (dp[idx]==max) {
                answer.add(arr[idx]);
                max--;
            }
            idx--;
        }
        Collections.reverse(answer);
        for (Integer e: answer) {
            builder.append(e).append(" ");
        }
        System.out.println(builder);
        bf.close();
    }
}
