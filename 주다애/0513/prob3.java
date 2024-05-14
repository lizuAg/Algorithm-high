package saffy;

import java.util.*;
import java.io.*;

// SWEA - 햄버거 다이어트
// 백트래킹으로 풀었음
// DP로도 풀어야 할텐데..
public class Swea5215 {
	static int n;
	static int t;
	static int[] score;
	static int[] calory;
	static int ans;
	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("src/saffy/input_5215.txt"));

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
			n = sc.nextInt();
			t = sc.nextInt();
			score = new int[n];
			calory = new int[n];
			ans = 0; // 초기화 안하면 안됨
			for(int i = 0; i < n; i++) {
				score[i] = sc.nextInt();
				calory[i] = sc.nextInt();
			}
			run(0, 0, 0);
			System.out.println("#" + test_case + " " + ans);
		}
	}
	
	static void run(int level, int scores, int calories) {
		if(calories >= t) {
			return;
		}
		if(level == n) {
			ans = Math.max(ans, scores);
			return;
		}
		// 나 선택 안 함
		run(level + 1, scores, calories);
		// 나 선택 함
		run(level + 1, score[level] + scores, calory[level] + calories);
	}
}
