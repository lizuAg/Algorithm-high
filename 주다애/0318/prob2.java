import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 마법사 상어와 토네이도(골드 3)
public class BaekJoon20057 {
    static int[][] shark;
    static int N;
    static boolean[][] visited;
    static int[][] dir = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}}; // 서 남 동 북
    static int answer;
    static int[][] dsx = {{-1,1,-2,-1,1,2,-1,1,0}, {-1,-1,0,0,0,0,1,1,2},
            {1,-1,2,1,-1,-2,1,-1,0}, {1,1,0,0,0,0,-1,-1,-2}};
    static int[][] dsy = {{1,1,0,0,0,0,-1,-1,-2},{-1,1,-2,-1,1,2,-1,1,0},
            {-1,-1,0,0,0,0,1,1,2},{1,-1,2,1,-1,-2,1,-1,0}};
    static int[] percent ={1,1,2,7,7,2,10,10,5};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        shark = new int[N][N];
        visited = new boolean[N][N];
        StringTokenizer st;
        // 입력
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                shark[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        int sx = N / 2;
        int sy = N / 2;
        visited[sx][sy] = true;
        while(true) {
            // 소멸
            if(sx == 0 && sy == 0) {
                break;
            }
            sx += dir[cnt % 4][0];
            sy += dir[cnt % 4][1];
            if(!visited[sx][sy]) {
                move(sx, sy, cnt % 4);
                visited[sx][sy] = true;
                cnt++;
            }
            else {
                sx -= dir[cnt % 4][0];
                sy -= dir[cnt % 4][1];
                sx += dir[(cnt+3) % 4][0];
                sy += dir[(cnt+3) % 4][1];
                move(sx, sy, (cnt+3) % 4);
                visited[sx][sy] = true;
            }
        }
        System.out.println(answer);
    }

    private static void move(int x, int y, int d) {
        int dx = dir[d][0];
        int dy = dir[d][1];
        int ax = x + dx;
        int ay = y + dy;

        int one = tornadoOne(x, y, d);
        int two = tornadoTwo(x, y, d);
        int five = tornadoFive(x, y, d);
        int seven = tornadoSeven(x, y, d);
        int ten = tornadoTen(x, y, d);

        int res = one + two + five + seven + ten;
        if(enableMove(ax, ay)) {
            shark[ax][ay] += (shark[x][y] - res);
        }
        else {
            answer += (shark[x][y] - res);
        }
    }

    private static int tornadoTen(int x, int y, int d) {
        int firstTen = calculate(x, y, d, 6);
        int secondTen = calculate(x, y, d, 7);
        return firstTen + secondTen;
    }

    private static int tornadoTwo(int x, int y, int d) {
        int firstTwo = calculate(x, y, d, 2);
        int secondTwo = calculate(x, y, d, 5);
        return firstTwo + secondTwo;
    }

    private static int tornadoSeven(int x, int y, int d) {
        int firstSeven = calculate(x, y, d, 3);
        int secondSeven = calculate(x, y, d, 4);
        return firstSeven + secondSeven;
    }

    private static int tornadoOne(int x, int y, int d) {
        int firstOne = calculate(x, y, d, 0);
        int secondOne = calculate(x, y, d, 1);
        return firstOne + secondOne;
    }

    private static int tornadoFive(int x, int y, int d) {
        int five = calculate(x, y, d, 8);
        return five;
    }

    private static int calculate(int x, int y, int d, int idx) {
        int amount = shark[x][y] * percent[idx] / 100;
        int m = 0;
        // 10%
        int nx = x + dsx[d][idx];
        int ny = y + dsy[d][idx];
        if(enableMove(nx, ny)) {
            shark[nx][ny] += amount;
        }
        else {
            answer += amount;
        }
        m += amount;
        return m;
    }

    private static boolean enableMove(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N);
    }
}
