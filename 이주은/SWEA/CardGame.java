import java.io.*;

class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int win, lose;
    
	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
            solve();
			bw.write("#"+test_case+" "+win+" "+lose+"\n");
		}
		br.close();
        bw.close();
	}
    
    static void solve() throws IOException {
        win = 0; lose = 0;
        
        String[] line = br.readLine().split(" ");
        int[] kyu = new int[9];
        int[] in = new int[9];
        boolean[] visited = new boolean[19];
        
        for(int i=0; i<9; i++) {
           kyu[i] = Integer.parseInt(line[i]);
           visited[kyu[i]] = true;
        }
        
        dfs(kyu, in, visited, 0);
    }
    
    static void dfs(int[] kyu, int[] in, boolean[] visited, int depth) {
        if(depth == 9) {
            calc(kyu, in);
        	return;
        }
        
       	for(int i=1; i<19; i++) {
            if(!visited[i]) {
                visited[i] = true;
                in[depth] = i;
            	dfs(kyu, in, visited, depth+1);
                visited[i] = false;
            }
        }
    }
    
    static void calc(int[] kyu, int[] in) {
    	int k=0, i=0;
            
        for(int j=0; j<9; j++) {
          	if(kyu[j] > in[j])
            	k += kyu[j] + in[j];
            else if(kyu[j] < in[j])
                i += kyu[j] + in[j];
            }
        if(k > i)
            win++;
        else if(k < i)
            lose++;
    }
}
