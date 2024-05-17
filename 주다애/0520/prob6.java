import java.util.Scanner;

// 평범한 배낭(골드 5)
public class BaekJoon12865 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt(); // 최대 무게
		int[] volume = new int[n + 1];
		int[] value = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			volume[i] = sc.nextInt(); // 무게
			value[i] = sc.nextInt(); // 가치
		}
		int[][] dp = new int[n + 1][k + 1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= k; j++) {
				// 넣으려는 무게가 최대 무게를 넘으면 -> 못 넣음
				if(volume[i] > j) {
					dp[i][j] = dp[i - 1][j];
				}
				// 넣으려는 무게가 최대 무게 이하면 -> 그 전의 물건을 빼고 넣거나, 안 넣거나
				else {
					dp[i][j] = Math.max(dp[i - 1][j], value[i] + dp[i -1][j - volume[i]]);
				}
			}
		}
		System.out.println(dp[n][k]);
	}
}
