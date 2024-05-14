package saffy;

import java.util.*;
import java.io.FileInputStream;

// greedy
public class Swea1859 {
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
			int[] stock = new int[n];
			// answer타입을 long으로 해줘야한다!
			long answer = 0;
			// 입력
			for(int i = 0; i < n; i++) {
				stock[i] = sc.nextInt();
			}
			int v = stock[n - 1];
			for(int i = n - 1; i >= 0; i--) {
				if(v >= stock[i]) {
					answer += v - stock[i];
				}
				else {
					v = stock[i];
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}
	}
}
