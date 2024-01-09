import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
  static List<List<List<Integer>>> box = new ArrayList<>();
	static int[][] move = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};
	static int N;
	static int M;
	static int H;
	static List<Integer> counts = new ArrayList<>();
	
	static int countNonRipenTomatoes() {
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (box.get(i).get(j).get(k) == 0)
						count++;
				}
			}
		}
		return count;
	}
	
	static boolean canMoveTo(int x, int y, int z) {
		return x>=0 && x<H && y>=0 && y<N && z>=0 && z<M && box.get(x).get(y).get(z)==0;
	}
    
  private static void bfs(Queue<Node> queue) {
    while(! queue.isEmpty()) {
			Node now = queue.poll();
			for (int[] direction: move) {
				int newX = now.x + direction[0];
				int newY = now.y + direction[1];
				int newZ = now.z + direction[2];
				if (canMoveTo(newX, newY, newZ)) {
					box.get(newX).get(newY).set(newZ, 1);
					queue.add(new Node(now.depth+1, newX, newY, newZ));
				}
			}
			counts.add(now.depth);
		}
	}

	public static void main(String[] args) throws IOException, NumberFormatException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> inputs = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
		M = inputs.get(0);
		N = inputs.get(1);
		H = inputs.get(2);
		
		for (int i = 0; i < H; i++) {
			box.add(new ArrayList<>());
			for (int j = 0; j< N; j++) {
				box.get(i).add(Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
			}
		}
		
    Queue<Node> queue = new LinkedList<>();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (box.get(i).get(j).get(k) == 1) {
						queue.add(new Node (0, i, j, k));
					}
				}
			}
		}
    bfs(queue);
		
		int answer = 0;
		for (int count: counts) {
			answer = Math.max(answer, count);
		}
		if (countNonRipenTomatoes() == 0) 
			System.out.println(answer);
		else 
			System.out.println(-1);
	}
	
	static class Node {
		int depth;
		int x; 
		int y; 
		int z;
		
		Node(int depth, int x, int y, int z) {
			this.depth = depth;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
