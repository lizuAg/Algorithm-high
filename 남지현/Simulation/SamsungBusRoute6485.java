import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        
        for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(bf.readLine());
            int[] counts = new int[5001];
            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                for (int j=start; j<=end; j++) {
                    counts[j]+=1;
                }
            }
            int P = Integer.parseInt(bf.readLine());
            StringBuilder builder = new StringBuilder();
            builder.append("#").append(test_case).append(" ");
            for (int i=0; i<P; i++) {
                builder.append(counts[Integer.parseInt(bf.readLine())]).append(" ");
            }
            System.out.println(builder.toString());
        }
        bf.close();
    }
}
