import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 펠린드롬?(골드 4)
// 시간초과 해결해야 함
// 이걸 dp로 풀 생각을 대체 어떻게 할까요?
public class BaekJoon10942 {
    static int[] palindrome;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean dp[][] = new boolean[N + 1][N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        palindrome = new int[N];
        for(int i = 0; i < N; i++) {
            palindrome[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < N - 1; i++) {
            if (palindrome[i] == palindrome[i + 1]) {
                dp[i][i + 1] = true;
            }
        }
        for(int len = 3; len <= N; len++) {
            for(int start = 0; start <= N - len; start++) {
                int end = start + len - 1;
                // 부분 배열의 첫과 끝이 같고
                // 처음과 끝 제외한 중간 값들이 펠린드롬이면
                // 펠린드롬이다.
                if(palindrome[start] == palindrome[end] && dp[start + 1][end - 1]) {
                    dp[start][end] = true;
                }
            }
        }
        int M = Integer.parseInt(br.readLine());
        // StringBuilider로 해줘야 시간초과 안 남
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            sb.append(dp[S - 1][E - 1] ? 1 : 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
