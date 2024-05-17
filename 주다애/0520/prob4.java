import java.util.*;
import java.io.*;
// String(D 3)
public class Swea1213 {
	public static void main(String args[]) throws Exception
	{
    /*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
//		int T;
//		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int n = sc.nextInt();
			String t = sc.next();
			String str = sc.next();
			int len = str.length();
			int tlen = t.length();
			int ans = 0;
			String temp = "";
			List<Character> list = new ArrayList<>();
			for(int i = 0; i < len; i++) {
				char c = str.charAt(i);
				list.add(c);
				if(list.size() == tlen) {
					for(int j = 0; j < tlen; j++) {
						temp += list.get(j);
					}
					if(temp.equals(t)) ans++;
					list.remove(0);
					temp = "";
				}
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}
}
