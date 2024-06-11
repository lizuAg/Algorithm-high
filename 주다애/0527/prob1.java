import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// 가장 긴 증가하는 부분 수열 4(골드 4)
public class BaekJoon14002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int len = 1;
        for(int i = 1; i < n; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    len = Math.max(len, dp[i]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(len + "\n");
        // stack을 사용하는 방벙도 있음(LIFO이므로)
        List<Integer> ans = new LinkedList<>();
        for(int i = n - 1; i >= 0; i--) {
            if(dp[i] == len) {
                ans.add(arr[i]);
                len -= 1;
            }
        }
        int size = ans.size();
        for(int i = size - 1; i >= 0; i--) {
            sb.append(ans.get(i) + " ");
        }
        System.out.println(sb);
    }
}
