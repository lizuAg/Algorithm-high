import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] jewelries = new int[N][2];
        int[] C = new int[K];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(bf.readLine());
            jewelries[i][0] = Integer.parseInt(st.nextToken());
            jewelries[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i=0; i<K; i++) {
            C[i] = Integer.parseInt(bf.readLine());
        }
        // 보석의 무게가 가벼운 순으로
        Arrays.sort(jewelries, (arr1, arr2) -> arr1[0]==arr2[0]? arr2[1]-arr1[1]: arr1[0]-arr2[0]);
        Arrays.sort(C);
        // 보석의 가치가 큰 순으로
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> arr1[1]==arr2[1]? arr1[0]-arr2[0]: arr2[1]-arr1[1]);
        long sum=0;
        int jIdx=0;
        for (int i=0; i<K; i++) {
            while (jIdx<N && jewelries[jIdx][0]<=C[i]) {
                pq.add(jewelries[jIdx]);
                jIdx++;
            }
            if (!pq.isEmpty()) sum += pq.poll()[1];
        }
        System.out.println(sum);
        bf.close();
    }
}
