import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] scv;
    static int[][][] memo;

    static int[][] attack = {{9, 3, 1}, {9, 1, 3}, 
                               {3, 9, 1}, {3, 1, 9}, 
                               {1, 9, 3}, {1, 3, 9}};

    public static void main(String[] args) throws IOException {
        getInput();
        
        dfs(scv[0], scv[1], scv[2], 0);

        System.out.println(memo[0][0][0]);   
    }

    private static void dfs(int a, int b, int c, int depth) {
        if(memo[0][0][0] <= depth)
            return;
        if(memo[a][b][c] != 0 && memo[a][b][c] <= depth)
            return;
        else
            memo[a][b][c] = depth;

        if(a == 0 && b == 0 && c == 0)
            return;

        for(int i=0; i<6; i++) {
            dfs(Math.max(a-attack[i][0], 0), Math.max(b-attack[i][1], 0), Math.max(c-attack[i][2], 0), depth+1);
        }
    }

    private static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        scv = new int[3];
        String[] line = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            scv[i] = Integer.parseInt(line[i]);
        }

        memo = new int[scv[0]+1][scv[1]+1][scv[2]+1];
        memo[0][0][0] = 61;
    }
}
