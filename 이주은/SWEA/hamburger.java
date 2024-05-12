import java.util.*;
import java.io.*;

class Solution
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			bw.write("#"+test_case+" "+solve()+"\n");
		}
        bw.flush();
	}
    
    static int solve() throws IOException {
    	String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int L = Integer.parseInt(line[1]);
        
        int[][] ingredients = new int[N][2]; //{점수, 칼로리}
        
        for(int i=0; i<N; i++) {
        	line = br.readLine().split(" ");
            ingredients[i][0] =  Integer.parseInt(line[0]);
            ingredients[i][1] = Integer.parseInt(line[1]);
        }
        
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 0}); //{진입할 노드, 점수 합, 칼로리 합}
        
        while(!queue.isEmpty()) {
        	int[] now = queue.poll();
            int next = now[0];
            int score = now[1];
            int cal = now[2];
            
			if(now[0] == N) {
            	answer = Math.max(answer, score);
                continue;
            }
            
            //다음 재료를 넣지 않는다.
            queue.add(new int[] {next+1, score, cal});
          	//다음 재료를 넣는다.
            cal += ingredients[next][1];
            if( cal< L ) {
            	queue.add(new int[] {next+1, score + ingredients[next][0], cal});
            }
        }
        return answer;
    }
}
