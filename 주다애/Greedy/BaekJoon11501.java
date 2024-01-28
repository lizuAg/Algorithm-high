import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 주식(실버 2)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        long[] stock;
        // 결과 저장 배열
        long[] res = new long[T];
        // 입력
        for(int i = 0 ; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            stock = new long[N];
            st = new StringTokenizer(br.readLine());
            long max = 0;
            for(int j = 0 ; j < N ; j++ ) {
                stock[j] = Integer.parseInt(st.nextToken());
            }
            for(int k = N - 1; k >= 0; k--) {
                if(stock[k] > max) {
                    // 최대값만 갱신
                    max = stock[k];
                }
                else {
                    // 차이만큼 더해줌
                    res[i] += (max - stock[k]);
                }
            }
        }
        for(long l : res) {
            System.out.println(l);
        }
    }
}
