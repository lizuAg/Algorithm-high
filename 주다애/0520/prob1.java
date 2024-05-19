import java.util.*;
import java.io.*;
// Magnetic(D 3)
public class Swea1220 {
	public static void main(String[] args) throws IOException {
		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T = 10;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
      // 크기는 100으로 고정
			int[][] mag = new int[100][100];
			// 입력
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					mag[i][j] = sc.nextInt();
				}
			}
			int ans = 0;
			List<Integer> temp = new ArrayList<Integer>();
			for(int i = 0; i < 100; i++) {
				temp.clear();
				for(int j = 0; j < 100; j++) {
					int t = mag[j][i];
					if(t == 1 || t == 2) {
						temp.add(t);
					}
				}
				ans += getDeadLock(temp);
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}
	
	static int getDeadLock(List<Integer> temp) {
		int cnt = 0;
		int len = temp.size();
		for(int i = 0; i <= len - 2; i++) {
			if(temp.get(i) == 1 && temp.get(i + 1) == 2) {
				cnt++;
			}
		}
		return cnt;
	}
}
