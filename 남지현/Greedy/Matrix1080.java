import java.util.*;
import java.io.*;

public class Matrix1080 {
    static int[][] dep;
    static int[][] dst;

    public static int solution(int N, int M) {
        if (N<3 || M<3) {
            return Arrays.deepEquals(dst, dep)? 0: -1;
        }
        int count=0;
        for (int i=0; i<=N-3; i++) {
            for (int j=0; j<=M-3; j++) {
                if (dep[i][j] != dst[i][j]) {
                    convert(i, j);
                    count++;
                }
            }
        }
        return Arrays.deepEquals(dst, dep)? count: -1;
    }

    private static void convert(int x, int y) {
        for (int i=x; i<x+3; i++) {
            for (int j=y; j<y+3; j++) {
                dep[i][j] = 1-dep[i][j];
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        dep = new int[N][M];
        dst = new int[N][M];
        for (int i=0; i<N; i++) {
            String[] arg = bf.readLine().split("");
            for (int j=0; j<M; j++) {
                dep[i][j] = Integer.parseInt(arg[j]);
            }
        }
        for (int i=0; i<N; i++) {
            String[] arg = bf.readLine().split("");
            for (int j=0; j<M; j++) {
                dst[i][j] = Integer.parseInt(arg[j]);
            }
        }
        System.out.println(solution(N, M));
    }
}
