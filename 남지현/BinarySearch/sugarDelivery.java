import java.io.*;

public class SugarDelivery2839 {
	
	public static int solution(int N) {
		int answer=-1;
		int start = N/5;
		for (int i=start; i>=0; i--) {
			int num = N-5*i;
			if (num%3 == 0) {
				answer = i+num/3;
				break;
			}
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(bf.readLine());
		System.out.println(solution(N));
	}
}
