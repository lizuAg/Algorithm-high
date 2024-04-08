//BOJ 14719번 빗물 (https://www.acmicpc.net/submit/14719/76348044)

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int H, W;
    static boolean[][] map;
    
    public static void main(String[] args) throws IOException {
        int answer = 0;
        input();

        for(int i=0; i<H; i++) {
            boolean flag;
            int cnt = -1;
            
            for(int j=0; j<W; j++) {
                //1. 벽을 처음 만났을 때(벽 O, cnt -1)
                if(map[i][j] && cnt==-1) {
                    cnt++;
                }
                //2. 벽을 다시 만났을 때 -> 물이 채워 짐.(벽O, cnt != -1)
                else if(map[i][j]){
                    answer += cnt;
                    cnt = 0;
                }
                //3. 물이 채워질 가능성이 있을 때 (벽X, cnt != -1)
                else if(cnt != -1) {
                    cnt++;
                }
                //4. 물이 채워지지 못할 때 (벽X, cnt -1)
                //do nothing
            }
        }
        System.out.println(answer);
    }
    
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new boolean[H][W];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<W; i++) {
            int h = Integer.parseInt(st.nextToken());
            for(int j=0; j<h; j++) {
                map[j][i] = true;
            }
        }
    }
}
