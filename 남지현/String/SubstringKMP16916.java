import java.io.*;

// 부분 문자열

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] str = bf.readLine().toCharArray();
        char[] sub = bf.readLine().toCharArray();
        int answer = 0;
        int N = str.length;
        int n = sub.length;
        int j = 0;
        int[] lps = new int[n];
        for (int i=1; i<n; i++) {
            while (j>0 && sub[i]!=sub[j]) {
                j = lps[j-1];
            }
            if (sub[i]==sub[j]) {
                lps[i] = ++j;
            }
        }
        j = 0;
        for (int i=0; i<N; i++) {
            while (j>0 && str[i]!=sub[j]) {
                j = lps[j-1];
            }
            if (str[i]==sub[j]) {
                if (j==n-1) {
                    answer=1;
                    break;
                } else {
                    j++;
                }
            }
        }
        System.out.println(answer);
    }
}
