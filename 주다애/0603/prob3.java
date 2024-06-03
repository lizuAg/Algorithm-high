import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 카드 정렬하기(골드 4)
// 그리디 + PQ
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        // long 타입
        long[] card = new long[n];
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            card[i] = Integer.parseInt(st.nextToken());
            pq.offer(card[i]);
        }
        long ans = 0;
        // 2개를 뽑으므로 size()로 판단해야 한다.
        while(pq.size() > 1) {
            long a = pq.poll();
            long b = pq.poll();
            long sum = a + b;
            ans += sum;
            pq.offer(sum);
        }
        System.out.println(ans);
    }
}
