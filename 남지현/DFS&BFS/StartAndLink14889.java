import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] S;
    static boolean[] visited;
    static int answer;

    static final int MAX = 10000;

    private static void makeTeam(int now, int depth) {
        if (depth==N/2) {
            int start = 0;
            int link = 0;
            for(int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (visited[i] && visited[j]) {
                        start += S[i][j];
                    } else if (!visited[i] && !visited[j]) {
                        link += S[i][j];
                    }
                }
            }
            answer = Math.min(answer, Math.abs(start-link));
            return;
        }
        for (int i=now+1; i<N; i++) {
            visited[i] = true;
            makeTeam(i, depth+1);
            visited[i] = false;
        }
    }
    
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        S = new int[N][N];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j=0; j<N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = MAX;
        visited =  new boolean[N];
        makeTeam(-1, 0);
        System.out.println(answer);
        bf.close();
    }
}
