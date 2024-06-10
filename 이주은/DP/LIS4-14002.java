import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] inputs;
    static int[][] dp;     //dp[i] = {i번째 인덱스에서 끝나는 LIS(최장 증가 수열)길이, 이전 인덱스}

    public static void main(String[] args) throws IOException {
        int end = 0;
        getInput();
        
        for(int i=0; i<N; i++) {
            dp[i][0] = 1;
            for(int j=0; j<i; j++) { // i번째 이전에 대해서,
               if(inputs[i] > inputs[j] && dp[i][0] < dp[j][0] + 1) { //현재 원소보다 작은 원소가 있다면    
                   dp[i] = new int[] {dp[j][0]+1, j};

                   if(dp[end][0] < dp[i][0]) end = i;
               }
            }
        }

        int[] arr = new int[dp[end][0]];
        int next = end;
        for(int i=dp[end][0]-1; i>=0; i--) {
            arr[i] = inputs[next];
            next = dp[next][1];
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(dp[end][0]+"\n");
        for(int i=0; i<arr.length; i++) {
            bw.write(arr[i]+" ");
        }
        bw.close();
    }

    static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N][2];
        inputs = new int[N];
    
        String[] line = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            inputs[i] = Integer.parseInt(line[i]);
        }
        
        br.close();
    }
}
