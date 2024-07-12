import java.util.*;
import java.io.*;

// 백준 1027 골드4 - 고층 건물 (기울기 비교 - 참고한 풀이)

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] H = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i=0; i<N; i++) {
            H[i] = Integer.parseInt(st.nextToken());
        }
        int[] scores = new int[N];
        for (int i=0; i<N-1; i++) {
            double degree = Integer.MIN_VALUE;
            for (int j=i+1; j<N; j++) {
                double curDegree = (double)(H[j] - H[i]) / (j - i);
                if (curDegree > degree) {
                    degree = curDegree;
                    scores[i]++;
                    scores[j]++;
                }
            }
        }
        int max=0;
        for (int i=0; i<N; i++) {
            max = Math.max(max, scores[i]);
        }
        System.out.println(max);
    }
}
