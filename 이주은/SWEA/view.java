import java.util.*;
import java.io.*;

class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
	public static void main(String args[]) throws Exception
	{
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			bw.write("#"+test_case+" "+solve()+"\n");
		}
        br.close();
        bw.close();
	}
    
    public static int solve() throws IOException {
        int answer = 0;
    	int N = Integer.parseInt(br.readLine());
        int[] map = new int[N];
        
        String[] line = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
        	map[i] = Integer.parseInt(line[i]);
        }
        
        for(int i=2; i<N-2; i++) {
        	int left = Math.max(map[i-1], map[i-2]);
            
            if(left > map[i])
                continue;
            
            int right = Math.max(map[i+1], map[i+2]);
            
            if(right > map[i])
                continue;
            
            answer += map[i] - Math.max(left, right);
        }
        
    	return answer;
    }
}
