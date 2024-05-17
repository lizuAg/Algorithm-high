import java.util.*;
import java.io.*;
// 삼성시의 버스 노선(D 3)
public class Swea6485 {
	public static void main(String args[]) throws Exception
	{
    /*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
			int[][] bus = new int[n][2];
			// A, B 입력
			for(int i = 0; i < n; i++) {
				bus[i][0] = sc.nextInt();
				bus[i][1] = sc.nextInt();
			}
			int p = sc.nextInt();
			int[] stop = new int[p + 1];
			// 정류장 입력
			for(int i = 1; i <= p; i++) {
				stop[i] = sc.nextInt();
			}
			// 크기는 최대 5000 + 1로
			int[] ans = new int[5001];
			for(int i = 0; i < n; i++) {
				int start = bus[i][0];
				int end = bus[i][1];
				for(int j = start; j <= end; j++) {
					ans[j] += 1;
				}
			}
			int[] arr = new int[p + 1];
			// index 값에 stop[i]를 넣어줘야 함
			for(int i = 1; i <= p; i++) {
				arr[i] = ans[stop[i]];
			}
			System.out.print("#" + test_case + " ");
			for(int i = 1; i <= p; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}
}
