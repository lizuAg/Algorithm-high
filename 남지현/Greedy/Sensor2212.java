import java.util.*;
import java.io.*;

// 센서 2212
class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int K = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] sensors = new int[N];
        for (int i=0; i<N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensors);
        int[] dists = new int[N-1];
        int prev = sensors[0];
        for (int i=1; i<N; i++) {
            int now = sensors[i];
            dists[i-1] = now-prev;
            prev = now;
        }
        Arrays.sort(dists);
        int sum=0;
        for (int i=0; i<N-K; i++) {
            sum += dists[i];
        }
        System.out.println(sum);
    }
}
