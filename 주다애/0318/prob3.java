import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 상어 초등학교(골드 5)
public class BaekJoon21608 {
    static int N;
    static Map<Integer, Integer[]> map;
    static int[][] res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        res = new int[N][N];
        StringTokenizer st;
        // 입력
        for(int i = 0; i < N*N; i++) {
            st = new StringTokenizer(br.readLine());
            int standard = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            // 저장
            map.put(standard, new Integer[]{a, b, c, d});
            // 내 자리 구하기
            pickSeat(standard);
        }
        // 만족도 구하기
        int satisfaction = getSatisfaction();
        System.out.println(satisfaction);
    }

    private static int getSatisfaction() {
        int[][] dir = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int sum = 0;
                Integer[] friends = map.get(res[i][j]);
                for(int[] d : dir) {
                    for(int k = 0; k < 4; k++) {
                        if(i+d[0] >= 0 && i+d[0] < N && j+d[1] >= 0 && j+d[1] < N
                        && res[i+d[0]][j+d[1]] == friends[k]) {
                            sum += 1;
                        }
                    }
                }
                if(sum == 0) count += 0;
                if(sum == 1) count += 1;
                if(sum == 2) count += 10;
                if(sum == 3) count += 100;
                if(sum == 4) count += 1000;
            }
        }
        return count;
    }

    private static void pickSeat(int target) {
        PriorityQueue<Seat> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(res[i][j] == 0) {
                    pq.offer(makeCandidate(i, j, target));
                }
            }
        }
        Seat seat = pq.poll();
        res[seat.x][seat.y] = target;
    }

    private static Seat makeCandidate(int x, int y, int target) {
        int like = 0;
        int empty = 0;
        Integer[] friends = map.get(target);
        int f1 = friends[0];
        int f2 = friends[1];
        int f3 = friends[2];
        int f4 = friends[3];
        int[][] dir = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        for(int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];
            if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                int f = res[nx][ny];
                if(f == 0) {
                    empty++;
                    continue;
                }
                if(f == f1 || f == f2 || f == f3 || f == f4) {
                    like++;
                }
            }
        }
        return new Seat(x, y, like, empty);
    }

    static class Seat implements Comparable<Seat> {
        int x;
        int y;
        int like;
        int empty;

        public Seat(int x, int y, int like, int empty) {
            this.x = x;
            this.y = y;
            this.like = like;
            this.empty = empty;
        }

        // 조건에 맞게 정렬
        @Override
        public int compareTo(Seat o) {
            if(this.like == o.like) {
                if(this.empty == o.empty) {
                   if(this.x == o.x) {
                       return this.y - o.y;
                   }
                   else {
                       return this.x - o.x;
                   }
                }
                return o.empty - this.empty;
            }
            return o.like - this.like;
        }
    }
}
