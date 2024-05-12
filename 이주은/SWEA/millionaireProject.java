import java.util.*;
import java.io.*;

class Solution
{
    static Scanner sc = new Scanner(System.in);
    
	public static void main(String args[]) throws Exception
	{
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            System.out.println("#"+test_case+" "+ solve());
		}
	}
    
    public static long solve() throws IOException {
        int n = sc.nextInt();
        int[] prices = new int[n];

        for(int i=0; i<n; i++) {
        	prices[i] = sc.nextInt();
        }
        
        long max = 0;
        long answer = 0;
        
        for(int i=n-1; i>=0; i--) {
            if(max > prices[i]) {
            	answer += max - prices[i];
            }
            else if(prices[i] > max) {
            	max = prices[i];
            }
        }
        return answer;
    }
}
