import java.util.*;
import java.io.*;

// View(D 3)
public class Swea1206 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 10개로 지정
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int n = sc.nextInt();
			int[] tower = new int[n];
			// 건물 높이 입력
			for(int i = 0; i < n; i++) {
				tower[i] = sc.nextInt();
			}
			int ans = 0;
			for(int i = 2; i <= n - 3; i++) {
				int ml = Math.max(tower[i - 2], tower[i - 1]);
				int mr = Math.max(tower[i + 2], tower[i + 1]);
				if(tower[i] <= ml || tower[i] <= mr) continue;
				ans += tower[i] - Math.max(ml, mr);
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}
}
