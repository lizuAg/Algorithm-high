package Algorithm.day_0701;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 센서
public class BaekJoon2212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        // 센서 하나씩 담당하면 됨
        if(k >= n) {
            System.out.println(0);
            return;
        }
        int[] sensor = new int[n];
        for (int i = 0; i < n; i++) {
            sensor[i] = sc.nextInt();
        }
        Arrays.sort(sensor);
        Integer[] diff = new Integer[n - 1];
        //  2 3 0 1 2
        for (int i = 0; i < n - 1; i++) {
            diff[i] = sensor[i + 1] - sensor[i];
        }
        // 3 2 2 1 0
        Arrays.sort(diff, Collections.reverseOrder());
        int answer = 0;
        for (int i = k - 1; i < n - 1 ; i++) {
            answer += diff[i];
        }
        System.out.println(answer);
    }
}
