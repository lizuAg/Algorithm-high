import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 - 트럭
// 트럭(실버 1)
public class BaekJoon13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        Queue<Integer> truck = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            truck.offer(Integer.parseInt(st.nextToken()));
        }

        // 하중 합
        int sum = 0;
        // 시간 합
        int answer = 0;

        for(Integer t : truck) {
            while(true) {
                if(bridge.size() == w) {
                    sum -= bridge.poll();
                    continue;
                }
                else if (sum + t > L){
                    sum += 0;
                    bridge.offer(0); // 0으로 채우기
                    answer++;
                }
                else {
                    break;
                }
            }
            sum += t;
            bridge.offer(t);
            answer++;
        }

        System.out.println(answer + w);
    }
}
