import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0; i<N; i++) {
            pq.add(Integer.parseInt(bf.readLine()));
        }
        int answer=0;
        while (pq.size()>1) {
            int sum = pq.poll() + pq.poll();
            pq.add(sum);
            answer+=sum;
        }
        System.out.println(answer);
    }
}
