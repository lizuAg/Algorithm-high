import java.util.*;

// 숨바꼭질 3(골드 5)
public class BaekJoon13549 {
    static int[] dist;
    static int V = 100000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        int K = Integer.parseInt(sc.next());
        dist = new int[V + 1];
        Arrays.fill(dist, -1);
        zeroOneBFS(N, K);
        System.out.println(dist[K]);
    }

    private static void zeroOneBFS(int start, int K) {
        Deque<Integer> d = new LinkedList<>();
        // 나 -> 나 : 거리=0
        dist[start] = 0;
        d.offer(start);

        while(!d.isEmpty()) {
            int v = d.removeFirst();
            // 찾으면
            if(v == K) {
                break;
            }

            if(v * 2 <= V && dist[v * 2] == -1) {
                d.offerFirst(v * 2);
                dist[v * 2] = dist[v];
            }

            // -1을 +1보다 먼저 해줘야함
            if(v - 1 >= 0 && dist[v - 1] == -1) {
                d.offerLast(v - 1);
                dist[v - 1] = dist[v] + 1;
            }

            if(v + 1 <= V && dist[v + 1] == -1) {
                d.offerLast(v + 1);
                dist[v + 1] = dist[v] + 1;
            }

        }
    }
}
