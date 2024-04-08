import java.io.*;
import java.util.*;

public class Main {
	
	private static int solution(int H, int W, int[] blocks) {
		int sum=0;
		for (int i=1; i<W-1; i++) {
			int left = 0;
			for (int j=0; j<i; j++) {
				left = Math.max(left, blocks[j]);
			}
			int right =0;
			for (int j=i+1; j<W; j++) {
				right = Math.max(right, blocks[j]);
			}
			if (blocks[i] < left && blocks[i] < right) {
				sum += Math.min(left, right) - blocks[i];
			}
		}
		return sum;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] arg = bf.readLine().split(" ");
		int H = Integer.parseInt(arg[0]);
		int W = Integer.parseInt(arg[1]);
		int[] blocks = new int[W];
		arg = bf.readLine().split(" ");
		for (int i=0; i<W; i++) {
			blocks[i] = Integer.parseInt(arg[i]);
		}
		System.out.println(solution(H, W, blocks));
		bf.close();
	}
}
