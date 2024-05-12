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
    	int n = Integer.parseInt(br.readLine());
        int[][] farm = new int[n][n];

        for(int i=0; i<n; i++) {
            String[] line = br.readLine().split("");
       		for(int j=0; j<n; j++) {
                farm[i][j] = Integer.parseInt(line[j]);
            }
        }
        
        int answer = 0;
        int offset = n/2;
        for(int i=0; i<n/2; i++) {
        	for(int j=offset; j<n-offset; j++) {
            	answer += farm[i][j];
            }
            offset--;
        }
       for(int i=n/2; i<n; i++) {
        	for(int j=offset; j<n-offset; j++) {
            	answer += farm[i][j];
            }
            offset++;
        }
        return answer;
    }
}
