//백준 1138번 한줄로 서기 (https://www.acmicpc.net/problem/1138)

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        LinkedList<Integer> list = new LinkedList<>();
        
        String[] line = br.readLine().split(" ");

        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(line[i-1]);
        }
     
        list.add(N);
        for(int i=N-1; i>0; i--) {            
            list.add(arr[i], i);
        }

        for(int j: list) {
            bw.write(j+" ");
        }
        bw.flush();
    }
}
