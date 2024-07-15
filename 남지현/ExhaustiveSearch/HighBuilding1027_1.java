import java.util.*;
import java.io.*;

// 백준 1027 골드4 - 고층 건물 (함수값 비교 - 내가 푼 풀이)

class Main {

    static int N;
    static int[] H;
    
    private static boolean isInvisible(int x1, int x2, int mid) {
        long left = (long)(H[x2]-H[x1])*(mid-x1);
        long right = (long)(H[mid]-H[x1])*(x2-x1);
        if (x2 > x1) return left<=right;
        else return left>=right;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        H = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i=0; i<N; i++) {
            H[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][] invisible = new boolean[N][N];
        for (int i=0; i<N; i++) {
            for (int j=i+2; j<N; j++) {
                for (int k=i+1; k<j; k++) {
                    if (isInvisible(i, j, k)) {
                        invisible[i][j] = true;
                        invisible[j][i] = true;
                        break;
                    }
                }
            }
        }
        int max=0;
        for (int i=0; i<N; i++) {
            int count=0;
            for (int j=0; j<N; j++) {
                if (i==j) continue;
                if (!invisible[i][j]) count++;
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}
