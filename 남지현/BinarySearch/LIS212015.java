import java.util.*;
import java.io.*;

// 가장 긴 증가하는 부분 수열2

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] LIS = new int[N];
        int len = 0;
        int num = -1;
        for (int i=0; i<N; i++) {
            num = Integer.parseInt(st.nextToken());
            int left=0;
            int right=len-1;
            if (i==0) {
                LIS[i] = num;
                len++;
            } else {
                while (left<right) {
                    int mid = (left+right)/2;
                    if (num<LIS[mid]) {
                        right = mid;
                    } else {
                        left = mid+1;
                    }
                }
                if (num < LIS[right] && ((right-1>=0 && num>LIS[right-1]) || right==0)) {
                    LIS[right] = num;
                } else if (num>LIS[right]){
                    LIS[right+1] = num;
                    len++;
                }
            }
        }
        System.out.println(len);
        bf.close();
    }
}
