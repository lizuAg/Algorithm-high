import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Stock11501 {
	static List<Integer> prices;
	static PriorityQueue<int[]> queue;
	
	public static long solution(int N) {
		int begin=0;
		long answer = 0;
		for (int i=0; i<N; i++) {
			queue.add(new int[]{i, prices.get(i)});
		}
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			if (node[0] >= begin) {
				for (int i = begin; i<node[0]; i++) {
					answer += (node[1]-prices.get(i));
				}
				begin = node[0]+1;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(bf.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.valueOf(bf.readLine());
			prices = Arrays.stream(bf.readLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
			queue = new PriorityQueue<>((arr1, arr2) -> arr2[1]-arr1[1]);
			System.out.println(solution(N));
		}
	}
}
