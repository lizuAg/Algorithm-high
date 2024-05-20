import java.util.*;
import java.io.*;

class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
	public static void main(String args[]) throws Exception
	{
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			bw.write("#"+test_case+" "+solve()+"\n");
		}
        br.close();
        bw.close();
	}
    
    static int solve() throws IOException {
        int N = Integer.parseInt(br.readLine());
        String target = br.readLine();
        String str = br.readLine();
        
        int lenS = str.length();
        int lenT = target.length();
        char last = target.charAt(lenT-1);
        
        int answer = 0;
       	for(int i=0; i<lenS; i++) {
            if(i >= lenT && str.charAt(i) == last) {
            	if(check(i-lenT+1, str, target, lenT))
                	answer++;
                }
            }
        
        return answer;
        }
    
    static boolean check(int start, String str, String target, int lenT) {
    	for(int i=0; i<lenT; i++) {
        	if(target.charAt(i) != str.charAt(start+i))
               return false;
        }
        return true;
    }
}
