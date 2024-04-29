import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	static int n;
	static int t;
	static int k;
	static int[][] dir = {
			{-1,0}, {-1,1}, {0,1}, {1,1}, {1,0},
			{1,-1}, {0,-1}, {-1,-1}
	};
	// 파이어볼 정보 입력해서 저장
	static List<FireBall> info = new ArrayList<>();
	static PriorityQueue<int[]> pq = new PriorityQueue<int[]>();
//			new Comparator<int []>() {
//				public int compare(int[] o1, int[] o2) {
//					if(o1[0] != o2[0]) return o1[1]-o2[1];
//					return o1[0] - o2[0];
//				}
//			});
	// 동일 좌표의 여러개의 파이어볼 관리
	static List<List<Queue<FireBall>>> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		for(int i = 0; i < t ; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			// 1. 정보 저장
			info.add(new FireBall(r, c, m, s, d));
		}
		
		q = new ArrayList<>();
		// 2. 이동 및 계산
		while(k --> 0) {
			move();
			calculate();
		}
		
		// 3. 출력
		int ans = 0;
		for(FireBall f : info) {
			ans += f.m;
		}
		System.out.println(ans);
	}
	
	private static void calculate() {
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				// 같은 칸에 2개 이상의 파이어볼이 있으면
				if(q.get(i).get(j).size() >= 2) {
					int size = q.get(i).get(j).size();
					int sm = 0;
					int ss = 0;
					boolean even = false;
					boolean odd = false;
					while(!q.get(i).get(j).isEmpty()) {
						FireBall f = q.get(i).get(j).poll();
						sm += f.m;
						ss += f.s;
						// 짝
						if(f.d % 2 == 0) {
							even = true;
						}
						// 홀
						else {
							odd = true;
						}
						// info에서 삭제
						info.remove(f);
						// 이 결과는 q에 저장 안하나?
						// move -> calculate가 한 쌍이므로 calculate하고 다음 턴의 move에서 결정
					}
					int nm = sm / 5;
					if(nm == 0) continue;
					int ns = ss / size;
					if ((odd && !even) || (!odd && even)) {
                        for (int k = 0; k <= 6; k += 2) {
                            info.add(new FireBall(i, j, nm, ns, k));
                        }
                    } else {
                        for (int k = 1; k <= 7; k += 2) {
                            info.add(new FireBall(i, j, nm, ns, k));
                        }
                    }
				}
				// 이걸 왜 해줘야 하나?
				// 어떤 조건인지 -> 다음 턴을 위해 현재 위치의 fb 상태 초기화
//				else {
//					q[i][j].clear();
//				}
			}
		}
	}
	
	private static void move() {
        q = new ArrayList<List<Queue<FireBall>>>();
		// 초기화
		for(int i = 0 ; i <= n; i++) {
			List<Queue<FireBall>> r = new ArrayList<>();
			for(int j = 0; j <= n; j++) {
				r.add(new LinkedList<>());
			}
			q.add(r);
		}
		for(FireBall b : info) {
			 b.r = (b.r + n + (dir[b.d][0] * (b.s % n)) - 1) % n + 1;
			 b.c = (b.c + n + (dir[b.d][1] * (b.s % n)) - 1) % n + 1;
			    
		     // 칸에도 저장
			 q.get(b.r).get(b.c).add(b);
		}
	} 
	
	// 상태 저장 class
	static class FireBall {
		int r;
		int c;
		int m;
		int s;
		int d;
		public FireBall(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.d = d;
			this.s = s;
		}
	}
}
