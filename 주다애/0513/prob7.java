import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 톱니바퀴(골드 5)
// 옆이 회전 안하면 나도 안한다.
// 회전 전에 판단해야 함
// 옆에 것이 회전 했는지 + 회전 전에 다른지 -> 이래야 회전함
// 문제를 제대로 읽자........
public class BaekJoon14891 {
    static int[][] gear;
    static int[][] spinInfo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gear = new int[4][8];
        StringTokenizer st;
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < 8; j++) {
                // '0' 빼주어야 함
                gear[i][j] = line.charAt(j) - '0';
            }
        }
        int k = Integer.parseInt(br.readLine());
        spinInfo = new int[k][2];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            // 0 -> N / 1 - > S
            spinInfo[i][0] = Integer.parseInt(st.nextToken());;
            spinInfo[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < k; i++) {
            // 회전
            spin(spinInfo[i][0], spinInfo[i][1]);
            // 나는 가장 마지막에 회전
            spinExecute(spinInfo[i][0] - 1, spinInfo[i][1]);
        }
        // 점수 합산
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            if(gear[i][0] == 0) continue;
            ans += Math.pow(2, i);
        }
        System.out.println(ans);
    }

    // 2,6번 숫자
    private static void spin(int num, int dir) {
        int t = num - 1;
        if(t == 1) {
            boolean flag = false;
            int cr = gear[2][2];
            // 0
            if(gear[t][6] != gear[0][2]) {
                spinExecute(0, dir * -1);
            }
            // 2
            if(gear[t][2] != gear[2][6]) {
                spinExecute(2, dir * -1);
                flag = true;
            }
            // 3
            if(flag && cr != gear[3][6]) {
                spinExecute(3, dir);
            }
        }
        if(t == 2) {
            boolean flag = false;
            int cl = gear[1][6];
            // 3
            if(gear[t][2] != gear[3][6]) {
                spinExecute(3, dir * -1);
            }
            // 1
            if(gear[t][6] != gear[1][2]) {
                spinExecute(1, dir * -1);
                flag = true;
            }
            // 0
            if(flag && cl != gear[0][2]) {
                spinExecute(0, dir);
            }
        }
        if(t == 0) {
            if(gear[0][2] == gear[1][6]) return;
            // 이걸 회전 전에 저장해주어야 제대로된 비교 가능!
            int cr = gear[1][2];
            int ncr = gear[2][2];
            spinExecute(1, dir * -1);
            if(cr == gear[2][6]) return;
            spinExecute(2, dir);
            if(ncr == gear[3][6]) return;
            spinExecute(3, dir * -1);
        }
        if(t == 3) {
            if(gear[3][6] == gear[2][2]) return;
            // 이걸 회전 전에 저장해주어야 제대로된 비교 가능!
            int cl = gear[2][6];
            int ncl = gear[1][6];
            spinExecute(2, dir * -1);
            if(cl == gear[1][2]) return;
            spinExecute(1, dir);
            if(ncl == gear[0][2]) return;
            spinExecute(0, dir * -1);
        }
    }

    static void spinExecute(int num, int dir) {
        int[] target;
        target = Arrays.copyOf(gear[num], 8);
        int temp[] = new int[8];
        if(dir == 1) {
            // 시계
            for (int i = 0; i < 8; i++) {
                temp[i] = target[(i + 7) % 8];
            }
        }
        else {
            // 반시계
            for (int i = 0; i < 8; i++) {
                temp[i] = target[(i + 9) % 8];
            }
        }
        gear[num] = temp;
    }
}
