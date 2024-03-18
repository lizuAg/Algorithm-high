import java.util.Arrays;
import java.util.Scanner;

// 단어 수학(골드 4)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 9;
        String[] arr = new String[n];
        int[] res = new int[26];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        int sum = 0;
        Arrays.sort(arr, (String s1, String s2) -> s2.length() - s1.length());
        for(int i = 0; i < n; i++) {
            int len = arr[i].length();
            for(int j = 0; j < len; j++) {
                char target = arr[i].charAt(j);
                res[target - 'A' + 0] += Math.pow(10, len - j - 1);
            }
        }
        Arrays.sort(res);
        for(int i = 25; i >= 0; i--) {
            sum += res[i] * num--;
        }
        System.out.println(sum);
    }
}
