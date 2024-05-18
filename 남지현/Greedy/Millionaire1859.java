import java.util.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        
        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[] prices = new int[N];
            for (int i=0; i<N; i++) {
                prices[i] = sc.nextInt();
            }
            long cost = 0;
            int max = prices[N-1];
            for (int i=N-2; i>=0; i--) {
                if (prices[i] > max) {
                    max = prices[i];
                } else {
                    cost += max - prices[i];
                }
            }
            StringBuilder builder = new StringBuilder();
            builder.append("#").append(test_case).append(" ").append(cost);
            System.out.println(builder.toString());
        }
        sc.close();
    }
}
