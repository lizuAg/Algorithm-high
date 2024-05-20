import java.util.*;
import java.io.*;

// 규영이와 인영이의 카드게임(D 3)
public class Swea6808 {
	static int win;
	static int lose;
	static int[] gue;
	static int[] een;
	static int[] path;
	// 중복 순얄 방지
	static boolean[] used;
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
			int[] arr = new int[19];
			win = 0;
			lose = 0;
			gue = new int[9];
			een = new int[9];
			path = new int[9];
			used = new boolean[9];
			for(int i = 0; i < 9; i++) {
				gue[i] = sc.nextInt();
				arr[gue[i]] = 1;
			}
			int k = 0;
			for(int i = 1; i <= 18; i++) {
				if(arr[i] == 0) een[k++] = i;
			}
			run(0);
			System.out.println("#" + test_case + " " + win + " " + lose);
		}
	}
	
	static void run(int level) {
		if(level == 9) {
			play(path);
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			if(used[i]) continue;
			path[level] = een[i];
			used[i] = true;
			run(level + 1);
			path[level] = 0;
			used[i] = false;
		}
	}
	
	static void play(int[] path) {
		int g = 0;
		int e = 0;
		for(int i = 0; i < 9; i++) {
			if(gue[i] > path[i]) g += gue[i] + path[i];
			else e += gue[i] + path[i];
		}
		if(g > e) win++;
		else if(g < e) lose++;
	}
}
