import java.util.*;
import java.io.*;

public class Main
{
	
	static int N;
	static int[][] map;
	
	static int[][][] blocks = {
			{{0,0}, {0,1}, {0,2}, {0,3}}, //ㅣ
        
			{{0,0}, {1,0}, {2,0}, {3,0}},  //ㅡ
        
			{{0,0}, {0,1}, {1,1}, {1,2}}, // z
        
			{{0,0}, {1,0}, {1,-1}, {2,-1}},
        
			{{0,0}, {0,1}, {0,2}, {1,2}}, //ㅗ
        
			{{0,0}, {1,0}, {2,0}, {2,-1}},
        
			{{0,0}, {1,0}, {1,1}, {1,2}},
        
			{{0,0}, {0,1}, {1,0}, {2,0}},
        
			{{0,0}, {0,1}, {0,2}, {1,1}},
        
			{{0,0}, {1,0}, {1,-1}, {2,0}},
        
			{{0,0}, {1,0}, {1,-1}, {1,1}},
        
			{{0,0}, {1,0}, {1,1}, {2,0}},
        
			{{0,0}, {1,0}, {0,1}, {1,1}} //ㅁ
	};
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test_case = 1;
		
		while (true) {
			N = Integer.parseInt(br.readLine().trim());
			
			if (N == 0) break;
			
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken().trim());
				}
			}
            
			sb.append(test_case++).append(". ").append(solve()).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int solve() {
		int max = Integer.MIN_VALUE;
		
		for (int idx = 0; idx < blocks.length; idx++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int sum = calSum(idx, i, j);
					max = Math.max(sum, max);
				}
			}
		}
		return max;
	}
	
	static int calSum(int idx, int r, int c) {
		int sum = 0;
		for (int i = 0; i < blocks[idx].length; i++) {
			int nr = r + blocks[idx][i][0];
			int nc = c + blocks[idx][i][1];
			
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
				return Integer.MIN_VALUE;
			}
			
			sum += map[nr][nc];
		}
		
		return sum;
	}
}
