package saffy;

import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Swea2805 {
	public static void main(String[] args) throws IOException {
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
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			// 입력
			for(int i = 0; i < N; i++) {
				// Scanner로 공백없는 입력 받는 방법
				String[] temp = sc.next().split("");
				for(int j = 0; j < N; j++) {
					// 정수를 파싱해올 때 i가 아닌 j를 받아줘야 한다.
					map[i][j] = Integer.parseInt(temp[j]);
				}
			}
			int standN = N / 2;
			int ans = 0;
			// 가운데 한 줄
			for(int i = 0; i < N; i++) {
				ans += map[standN][i];
			}
			// 위 삼각형
			for(int i = 0; i < standN; i++) {
				for(int j = standN - i; j < standN - i  + (i * 2 + 1); j++) {
					ans += map[i][j];
				}
			}
			int k = 1;
			// 아래 삼각형
			for(int i = standN + 1; i < N; i++) {
				for(int j = k; j <= standN * 2 - k; j++) {
					ans += map[i][j];
				}
				k += 1;
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}
}
