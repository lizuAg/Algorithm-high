import java.util.*;
import java.io.*;

class Solution {
    
    static boolean[] visited;
    static int[] kyu;
    static int count;
    
    static final int SUM = 9*8*7*6*5*4*3*2;

    private static void dfs(int round, int kyuScore, int inScore) {
        if (round==10) {
            if (kyuScore > inScore) count++;
            return;
        }
        for (int i=1; i<=18; i++) {
            if (!visited[i]) {
                int newKyuScore = kyuScore;
                int newInScore = inScore;
                if (kyu[round] > i) {
                    newKyuScore = kyuScore+kyu[round]+i;
                } else if (kyu[round] < i) {
                    newInScore = inScore+kyu[round]+i;
                }
                visited[i] = true;
                dfs(round+1, newKyuScore, newInScore);
                visited[i] = false;
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for (int test_case=1; test_case<=N; test_case++) {
            kyu = new int[10];
            visited = new boolean[19];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i=1; i<=9; i++) {
                kyu[i] = Integer.parseInt(st.nextToken());
                visited[kyu[i]] = true;
            }
            count=0;
            dfs(1, 0, 0);
            StringBuilder builder = new StringBuilder();
            builder.append("#").append(test_case).append(" ").append(count).append(" ").append(SUM-count);
            System.out.println(builder.toString());
        }
        bf.close();
    }
}
