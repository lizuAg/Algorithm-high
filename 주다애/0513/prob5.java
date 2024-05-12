import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스타트와 링크(실버 1)
// 1. 시간 초과 -> 중복 조합 제거
public class BaekJoon14889 {
    static int[][] map;
    static int n;
    static int half;
    static int[] path;
    static boolean[] used;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        half = n / 2;
        map = new int[n][n];
        path = new int[half];
        used = new boolean[n];
        // 입력
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        run(0, 0);
        System.out.println(min);
    }

    private static void run(int start, int level) {
        if(level == half) {
            getComb(path, used);
            return;
        }

        for(int i = start; i < n; i++) {
            if(used[i]) continue;
            used[i] = true;
            path[level] = i;
            run(i + 1, level + 1);
            path[level] = 0;
            used[i] = false;
        }
    }

    private static void getComb(int[] path, boolean[] used) {
        int startSum = 0;
        int linkSum = 0;
        // start에 속하는 그룹 점수 합
        for(int i = 0; i < half; i++) {
            int first = path[i];
            for(int j = 0; j < half; j++) {
                if(i == j) continue;
                startSum += map[first][path[j]];
            }
        }
        int[] link = new int[half];
        int k = 0;
        // link에 속하는 그룹 찾기
        for(int i = 0; i < n; i++) {
            if(!used[i]) link[k++] = i;
        }
        // link에 속하는 그룹 점수 합
        for(int i = 0; i < half; i++) {
            int first = link[i];
            for(int j = 0; j < half; j++) {
                if(i == j) continue;
                linkSum += map[first][link[j]];
            }
        }
        min = Math.min(Math.abs(startSum - linkSum), min);
    }
}
