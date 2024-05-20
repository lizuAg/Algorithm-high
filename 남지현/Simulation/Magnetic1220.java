import java.util.*;
import java.io.*;

class Solution {
    
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        final int T = 10;
        final int N = 100;
        
        for(int test_case = 1; test_case <= T; test_case++) {
            bf.readLine();
            char[][] table = new char[N][N];
            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int j=0; j<N; j++) {
                    table[i][j] = st.nextToken().charAt(0);
                }
            }

            int answer=0;
            for (int i=0; i<N; i++) { // 각 열에 대해서
                int idx=0;
                while (idx < N) {
                    if (table[idx][i]=='1') { // 아래로
                        int tmp = idx;
                        do {
                            idx++;
                        } while (idx<N && table[idx][i] == '0');
                        if (idx>=N) {
                            // 떨어진다.
                            table[tmp][i] = '0';
                            idx = tmp;
                        } else if (table[idx][i] == '2') {
                            answer++;
                            table[idx][i] = '3'; // 교착 상태
                        }
                        // 같은 극을 만날 경우 그냥 같이 밀어버린다.
                    } else if (table[idx][i]=='2') { // 위로
                        int tmp = idx;
                        do {
                            idx--;
                        } while(idx>=0 && table[idx][i]=='0');
                        if (idx<0) {
                            table[tmp][i] = '0';
                            idx = tmp;
                        } else if (table[idx][i] == '1'){
                            answer++;
                            table[idx][i] = '3';
                        }
                        idx = tmp+1;
                    } 
                    idx++;
                }
            }
            StringBuilder builder = new StringBuilder();
            builder.append("#").append(test_case).append(" ").append(answer);
            System.out.println(builder.toString());
        }
        bf.close();
    }
}
