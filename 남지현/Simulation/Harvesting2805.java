import java.io.*;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        
        for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(bf.readLine());
            int[][] farm = new int[N][N];
            for (int i=0; i<N; i++) {
                String[] input = bf.readLine().split("");
                for (int j=0; j<N; j++) {
                    farm[i][j] = Integer.parseInt(input[j]);
                }
            }
            int sum = 0;
            int mid = N/2;
            for (int i=0; i<mid; i++) {
                for (int j=-1*i; j<=i; j++) {
                    sum += farm[i][mid+j] + farm[N-i-1][mid+j];
                }
            }
            for (int i=0; i<N; i++) {
                sum += farm[mid][i];
            }
            StringBuilder builder = new StringBuilder();
            builder.append("#").append(test_case).append(" ").append(sum);
            System.out.println(builder.toString());
        }
        bf.close();
    }
}
