//백준 1027번 고층 건물

import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] buildings;
    static int[] cnt;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        buildings = new int[N];
        cnt = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }


        for(int A=0; A<buildings.length; A++) {
            double g1 = buildings[A];
            double g2 = -buildings[A];
                
            for(int B=A-1; B>=0; B--) {
                double g = getGradient(A, B);
                if(g < g1) {
                    g1 = g;
                    cnt[A] ++;
                    if(buildings[B] == 1_000_000_000)
                        break;
                }
            }

            for(int B=A+1; B<buildings.length; B++) {
                double g = getGradient(A, B);
                if(g > g2) {
                    
                    g2 = g;
                    cnt[A] ++;
                    if(buildings[B] == 1_000_000_000)
                        break;
                }
            }
        }

        Arrays.sort(cnt);
        System.out.println(cnt[N-1]);
        
    }

    private static double getGradient(int a, int b) {
        double deltaX = a - b;
        double deltaY = buildings[a] - buildings[b];

        return deltaY / deltaX;
    }
}
