import java.util.*;
import java.io.*;

class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			bw.write("#"+test_case+solve()+"\n");
		}
        bw.close();
        br.close();
	}
    
    public static String solve() throws IOException {
    	int N = Integer.parseInt(br.readLine());
        int[] stations = new int[5001];
        
        for(int i=0; i<N; i++) {
        	String[] line = br.readLine().split(" ");
            int s = Integer.parseInt(line[0]);
            int e = Integer.parseInt(line[1]);
            
            for(int j=s; j<=e; j++) {
            	stations[j] ++;
            }
        }
        int P = Integer.parseInt(br.readLine());
        sb.setLength(0);
        for(int i=0; i<P; i++) {
        	int station = Integer.parseInt(br.readLine());
    		sb.append(" "+stations[station]);
        }
        return sb.toString();
        }
}
