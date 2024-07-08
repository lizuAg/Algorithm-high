import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] arr;
    static int[][][] dp;

    static int[] attack = {9, 3, 1};
    
    public static void main(String[] args) throws IOException {
        getInput();

        dfs(arr[0], arr[1], arr[2], 0);

        System.out.println(dp[0][0][0]);   
    }

    private static void dfs(int a, int b, int c, int depth) {
        a = Math.max(a, 0);
        b = Math.max(b, 0);
        c = Math.max(c, 0);
        
        if(dp[a][b][c] == 0)
            dp[a][b][c] = depth;
        else if(dp[a][b][c] < depth)
            return;
        else
            dp[a][b][c] = Math.min(dp[a][b][c], depth);
        
        if(a == 0 && b == 0 && c == 0)
            return;
        
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(i==j)
                    continue;
                for(int k=0; k<3; k++) {
                    if(i == k || j == k)
                        continue;
                    
                    dfs(a-attack[i], b-attack[j], c-attack[k], depth+1);
                }
            }
        }
    }

    private static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[3];
        String[] line = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        
        dp = new int[arr[0]+1][arr[1]+1][arr[2]+1];
    }
}
