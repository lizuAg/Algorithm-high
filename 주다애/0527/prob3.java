import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 보석 도둑(골드 2)
// 1. 시간 초과 -> 처음부터 pq에 넣지 않고 조건 따지면서 넣기
// 2. 정렬 기준 -> 보석을 모아둔 List와 PQ는 다르다.
// 3. 놓친 부분 -> sum의 타입이 long이어야 한다.
public class BaekJoon1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] bag = new int[k];
        List<Gem> gems = new ArrayList<>();
        // 가치 기준 내림차순
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        // 입력
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            gems.add(new Gem(m, v));
        }
        for(int i = 0; i < k; i++) {
            bag[i] = (Integer.parseInt(br.readLine()));
        }
        Arrays.sort(bag);
        Collections.sort(gems);
        // long타입으로 선언해주어야 한다.
        long sum = 0;
        int idx = 0;

        for(int i = 0; i < k; i++) {
            while(idx < n) {
                Gem gem = gems.get(idx);
                if(gem.m > bag[i]) break;
                pq.offer(gem.v);
                idx++;
            }
            if(!pq.isEmpty()) sum += pq.poll();
        }
       System.out.println(sum);
    }

    static class Gem implements Comparable<Gem> {
        int m;
        int v;

        public Gem(int m, int v) {
            this.m = m;
            this.v = v;
        }

        // 무게 기준 오름차순
        @Override
        public int compareTo(Gem o) {
            return this.m - o.m;
        }
    }
}
