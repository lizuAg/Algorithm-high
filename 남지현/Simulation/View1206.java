import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int test_case=1; test_case<=T; test_case++) {
            int N = Integer.parseInt(bf.readLine());
            int[] H = new int[N];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i=0; i<N; i++) {
                H[i] = Integer.parseInt(st.nextToken());
            }
            int count=0;
            for (int i=2; i<N-2; i++) {
                int left=H[i];
                if (H[i]>H[i-1] && H[i]>H[i-2]) {
                    left = Math.max(H[i-1], H[i-2]);
                }
                int right=H[i];
                if (H[i]>H[i+1] && H[i]>H[i+2]) {
                    right = Math.max(H[i+1], H[i+2]);
                }
                count += Math.min(H[i]-left, H[i]-right);
            }
            StringBuilder builder = new StringBuilder();
            builder.append("#").append(test_case).append(" ").append(count);
            System.out.println(builder.toString());
        }
        bf.close();
    }
}
