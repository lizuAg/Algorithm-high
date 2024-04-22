import java.util.*;
import java.io.*;

public class Main {
	
	static final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static final int[][] dir = {{0, 2, 4, 6}, {1, 3, 5, 7}};
    static Map<Point, List<int[]>> map;

    private static int solution(int N, int M, int K, List<int[]> balls) {
    	for (int n=0; n<K; n++) {
    		map = new HashMap<>();
    		for (int i=0; i<balls.size(); i++) {
    			int nx =  calculateIdx(balls.get(i)[0] + balls.get(i)[3]*dx[balls.get(i)[4]], N);
    			int ny =  calculateIdx(balls.get(i)[1] + balls.get(i)[3]*dy[balls.get(i)[4]], N);
    			Point np = new Point(nx, ny);
    			if (! map.containsKey(np)) {
    				map.put(np, new ArrayList<>());
    			}
    			map.get(np).add(balls.get(i));
    		}
            for (Map.Entry<Point, List<int[]>> entry : map.entrySet()) {
                Point point = entry.getKey();
    			List<int[]> ballList = entry.getValue();
    			int count = ballList.size();
    			if (count == 1) {
    				for (int[] ball: ballList) {
    					ball[0] = point.x;
    					ball[1] = point.y;
    				}
    			} else {
    				int sumMass=0;
    				int sumSpeed=0;
    				List<int[]> removed = new ArrayList<>();
    				for (int[] ball: ballList) {
    					sumMass += ball[2];
    					sumSpeed += ball[3];
    					removed.add(ball);
    				}
    				boolean isEven = removed.get(0)[4]%2==0;
    				int dirIdx = 0;
    				for (int i=1; i<count; i++) {
    					if (isEven != (removed.get(i)[4]%2==0)) {
    						dirIdx = 1;
    						break;
    					}
    					isEven = removed.get(i)[4]%2==0;
    				}
    				for (int[] tmp: removed) {
    					balls.remove(tmp);
    				} 
    	    		if (sumMass/5 > 0) {
    	    			for (int i=0; i<4; i++) {
    	    				balls.add(new int[]{point.x, point.y, sumMass/5, sumSpeed/count, dir[dirIdx][i]});
    	    			}
    	    		}
    			}
    		}
    	}
    	int sum=0;
    	for (int[] ball: balls) {
			sum+=ball[2];
		}
        return sum;
    }

    private static int calculateIdx(int idx, int N) {
        int mod = idx % N;
        if (mod <= 0)
            mod += N;
        return mod;
    }

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<int[]> balls = new ArrayList<>();
        for (int i=0; i<M; i++) {
            String[] arg = bf.readLine().split(" ");
            int[] e = new int[5];
            for (int j=0; j<5; j++) {
            	e[j] = Integer.parseInt(arg[j]);
            }
            balls.add(e);
        }
        System.out.println(solution(N, M, K, balls));
	}
	
	static class Point {
        int x;
        int y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object o) {
            if (this==o)
                return true;
            if (this.getClass()!=o.getClass())
                return false;
            Point p = (Point) o;
            return this.x==p.x && this.y==p.y;
        }

        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
