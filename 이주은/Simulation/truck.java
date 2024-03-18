//BOJ 13335 트럭

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] trucks = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            trucks[i] = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        int sum=0, timer=0;
        
        for(int truck : trucks) {
            //진입 불가 해소
            while(true) {
                //트럭 수(다리 길이)제한
                if(queue.size() >= w){
                    sum -= queue.poll();
                }
                //무게 제한
                else if(sum + truck > L) {
                    queue.add(0);
                    timer++;
                }
                //진입 가능
                else
                    break;
            }
            
            //진입
            queue.add(truck);
            sum += truck;
            timer++;
        }
        
        System.out.println(timer + w);
    }
}
