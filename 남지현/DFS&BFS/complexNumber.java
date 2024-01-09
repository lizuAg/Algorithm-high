import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ComplexNumber {
	static List<List<Integer>> map = new ArrayList<>();
	static List<Integer> complex = new ArrayList<>();
	static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int count;
	
	static void dfs(int idx, int x, int y, int depth) {
		count++;
		for (int i = 0; i < 4; i++) {
			int newX = x + move[i][0];
			int newY = y + move[i][1];
			if (canMoveTo(newX, newY)) {
				map.get(newX).set(newY, idx);
				dfs(idx, newX, newY, depth++);
			}
		}
	}
	
	static boolean canMoveTo(int x, int y) {
		int size = map.size();
		return x>=0 && x<size && y>=0 && y<size && map.get(x).get(y)==1;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			map.add(Arrays.stream(br.readLine().split("")).map(Integer::parseInt).collect(Collectors.toList()));
		}
		int idx = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map.get(i).get(j) == 1) {
					count = 0;
					map.get(i).set(j, idx);
					dfs(idx, i, j, 0);
					idx++;
					complex.add(count);
				}
			}
		}
		
		Collections.sort(complex);
		System.out.println(complex.size());
		for (int cnt: complex)
			System.out.println(cnt);
	}
}
