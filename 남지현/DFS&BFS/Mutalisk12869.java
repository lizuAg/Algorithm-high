import java.util.*;
import java.io.*;

// 12869 뮤탈리스크

class Main {

    static int min;
    static boolean[][][] visited;
    static int[] arr;
    
    static final int MAX = 61;
    static final int[][] comb = {{-9, -3, -1}, {-9, -1, -3}, 
                               {-3, -9, -1}, {-3, -1, -9}, 
                               {-1, -9, -3}, {-1, -3, -9}};

    private static void dfs(int[] scv, int count) {

        if (scv[0]==0 && scv[1]==0 && scv[2]==0) {
            min = Math.min(min, count);
            return;
        }

        Arrays.sort(scv);
        
        if (visited[scv[2]][scv[1]][scv[0]]){
            return;
        } else {
            visited[scv[2]][scv[1]][scv[0]]=true;
        }
        if (min<count){
            return;
        }

        for (int i=0; i<6; i++) {
            dfs(new int[]{Math.max(scv[2]+comb[i][0], 0), 
                          Math.max(scv[1]+comb[i][1], 0), 
                          Math.max(scv[0]+comb[i][2], 0)}, count+1);
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        arr = new int[3];
        visited = new boolean[MAX][MAX][MAX];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        min = Integer.MAX_VALUE;
        dfs(Arrays.copyOf(arr, 3), 0);
        System.out.println(min);
    }
}
