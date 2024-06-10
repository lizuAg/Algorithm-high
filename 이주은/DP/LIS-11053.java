import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] inputs;
    static int[] dp;     //dp[i] = i번째 인덱스에서 끝나는 LIS(최장 증가 수열)길이

    public static void main(String[] args) throws IOException {
        int answer = 1;
        getInput();

        Arrays.fill(dp, 1); //LIS 최소값 1(자기자신)
        
        for(int i=1; i<N; i++) {
            for(int j=0; j<i; j++) { // i번째 이전에 대해서,
               if(inputs[i] > inputs[j]) { //현재 원소보다 작은 원소가 있다면
                   dp[i] = Math.max(dp[i], dp[j]+1);  //이전 LIS에서 현재 원소를 붙여 연장할 수 있다.

                   if(answer < dp[i]) answer = dp[i];
               }
            }
        }
        System.out.println(answer);
    }

    static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N];
        inputs = new int[N];
    
        String[] line = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            inputs[i] = Integer.parseInt(line[i]);
        }
        
        br.close();
    }
}
