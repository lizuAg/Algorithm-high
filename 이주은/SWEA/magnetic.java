import java.io.*;

class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
    static final int CELL_EMPTY = 0;
    static final int CELL_N = 1;
    static final int CELL_S = 2;
    
	public static void main(String args[]) throws Exception
	{
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			bw.write("#"+test_case+" "+solve()+"\n");
		}
        br.close();
        bw.close();
	}
    
    static int solve() throws Exception {
        int N = Integer.parseInt(br.readLine());
        int[][] table = new int[100][100];
        int answer = 0;
        
        for(int i=0; i<100; i++) {
            String[] line = br.readLine().split(" ");
            for(int j=0; j<100; j++) {
                table[i][j] = Integer.parseInt(line[j]); // 0 빈칸 1N 2S 위에는 2S 밑에는 1N
            }
        }
        
        for(int i=0; i<100; i++) {
            int j;
            for(j=0; j<100; j++) {
                if (table[j][i] == CELL_S)
                    table[j][i] = CELL_EMPTY;
                else if(table[j][i] == CELL_N)
                    break;
            }
            if(j == 100) continue;
            
            for(j=99; j>=0; j--) {
            	if(table[j][i] == CELL_N)
                    table[j][i] = CELL_EMPTY;
                else if(table[j][i] ==CELL_S)
                    break;
            }
            if(j == -1) continue;
            
            boolean flag = false;
            for(j=0; j<100; j++) {
            	if ((table[j][i] == CELL_N) && !flag)
                    flag = true;
                else if ((table[j][i] == CELL_S) && flag) {
                	answer ++;
                    flag = false;
                }
            }
        }
        return answer;
    }
}
