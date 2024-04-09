import java.util.*;
import java.io.*;

public class PowerBarScheduling1700 {
	
	private static int solution(int N, int K, int[] things) {
		Map<Integer, Queue<Integer>> lastUsed = new HashMap<>();
		int count=0;
		for (int i=0; i<things.length; i++) {
			if (! lastUsed.containsKey(things[i])) {
				lastUsed.put(things[i], new LinkedList<>());
			}
			lastUsed.get(things[i]).add(i);
		} 
		Integer[] powerBar = new Integer[N];
		Arrays.fill(powerBar, 0);
		for (int i=0; i<things.length; i++) {
			boolean isFull = true;
			for (int j=0; j<N; j++) {
				if (powerBar[j] == things[i]) {
					isFull = false;
					break;
				}
				if (powerBar[j]  == 0) {
					powerBar[j] = things[i];
					isFull = false;
					break;
				}
			}
			if (isFull) {
				int j;
				for (j=0; j<N; j++) {
					if (lastUsed.get(powerBar[j]).isEmpty()) {
						powerBar[j] = things[i];
						count++;
						break;
					}
				}
				if (j == N) {
					Arrays.sort(powerBar, (Integer i1, Integer i2) ->lastUsed.get(i2).peek()-lastUsed.get(i1).peek());
					powerBar[0] = things[i];
					count++;
				}
			}
			lastUsed.get(things[i]).poll();
		}
		return count;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int[] things = new int[K];
		for (int i=0; i<K; i++) {
			things[i] = Integer.parseInt(st.nextToken());
		}
		System.out.print(solution(N, K, things));
	}
}
