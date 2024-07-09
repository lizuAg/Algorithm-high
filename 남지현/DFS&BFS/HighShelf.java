import java.util.*;
import java.io.*;

// 1486. 장훈이의 높은 선반

class Solution {

    static int min;
    static int N;
    static int B;
    static int[] H;

    static final int MAX = 200_000;

    private static void dfs(int sum, int idx) {
        if (sum >= B) {
            min = Math.min(min, sum);
            return;
        }
        
        for (int i=idx-1; i>=0; i--) {
            dfs(sum+H[i], i);
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int test_case=1; test_case<=T; test_case++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bf.readLine());
            min = MAX+B;
            H = new int[N];
            for (int i=0; i<N; i++) {
                H[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(H);
            dfs(0, N);
            sb.append("#").append(test_case).append(" ").append(min-B).append("\n");
        }
        System.out.print(sb);
    }
}
