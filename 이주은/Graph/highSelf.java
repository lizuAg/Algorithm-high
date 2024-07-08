//SWEA 1486. 장훈이의 높은선반

import java.io.*;
import java.util.*;

class Solution
{
    static int T;
    static int N, B;
    static int[] clerks;
    static boolean[] visited;
    static int answer;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
	public static void main(String args[]) throws Exception
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
      	int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            answer = Integer.MAX_VALUE;
            getInput();
            
            dfs(0, 0);
            
            bw.write("#"+test_case+" "+answer+"\n");
		}
        bw.flush();
	}
    
    private static void dfs(int i, int sum) {
		if(i == N){
            if( sum >= B)
                answer = Math.min(answer, sum - B);

            return;
        }
        
        dfs(i+1, sum+clerks[i]);
        dfs(i+1, sum);
    }
    
	private static void getInput() throws Exception {
        String[] line = br.readLine().split(" ");
    	N = Integer.parseInt(line[0]);
        B = Integer.parseInt(line[1]);
        
        clerks = new int[N];
        visited = new boolean[N];
        
        line = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
        	clerks[i] = Integer.parseInt(line[i]);
        }
    }
}
