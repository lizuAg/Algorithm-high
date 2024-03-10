// 백준 - 치킨 배달
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 치킨 배달(골드 5)
public class Main {
    static int[][] map;
    static int M;
    static int N;
    static List<int[]> chicken = new ArrayList<>();
    static List<int[]> house = new ArrayList<>();
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        // 입력
        for(int i = 0 ;i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 치킨, 집 좌표 저장
        for(int i = 0 ;i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                }
                if(map[i][j] == 1) {
                    house.add(new int[]{i, j});
                }
            }
        }
        run(0, new ArrayList<>());
        System.out.println(ans);
    }

    private static void run(int start, List<Integer> selected) {
        if(selected.size() == M) {
            int sum = 0;
            for(int[] h : house) {
                int min = Integer.MAX_VALUE;
                for(int i : selected) {
                    int[] c = chicken.get(i);
                    int dist = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                    min = Math.min(min, dist);
                }
                sum += min;
            }
            ans = Math.min(ans, sum);
            return;
        }

        for(int i = start; i < chicken.size(); i++) {
            selected.add(i);
            run(i + 1, selected);
            selected.remove(selected.size() - 1);
        }
    }
}
