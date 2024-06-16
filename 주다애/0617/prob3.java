package Algorithm.day_0617;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 한 줄로 서기(실버 2)
public class BaekJoon1138 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] line = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            line[i] = sc.nextInt();
        }
        List<Integer> res = new ArrayList<>();
        for(int i = N; i > 0; i--) {
            res.add(line[i], i); // index, value
            // set()을 사용하려면 list를 미리 초기화 해야 함
        }
        for(int k : res) {
            System.out.print(k + " ");
        }
    }
}
