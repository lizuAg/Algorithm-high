import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon20437 {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while (t --> 0) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());

            getResult(w, k);
        }
        System.out.println(sb);
    }

    private static void getResult(String w, int k) {
        if(k == 1) {
            sb.append("1 1");
            return;
        }

        // 알파벳 몇번 나왔는지 저장
        int[] alpha = new int[26];
        for(int i = 0 ; i < w.length() ; i++) {
            alpha[w.charAt(i) - 'a']++;
        }
        int len = w.length();
        int min = len + 1;
        int max = -1;

        for(int i = 0 ; i < len ; i++) {
            // k개 이하인 문자는 탐색할 필요 없음
            if(alpha[w.charAt(i) - 'a'] < k) continue;
            int cnt = 1;
            for(int j = i + 1 ; j < len; j++) {
                // 같으면 cnt 증가
                if(w.charAt(i) == w.charAt(j)) cnt++;
                if(cnt == k) {
                    min = Math.min(min, j - i + 1);
                    max = Math.max(max, j - i + 1);
                    break;
                }
            }
        }
        if(min == len + 1 || max == -1) {
            sb.append("-1").append("\n");
            return;
        }
        sb.append(min + " " + max).append("\n");
    }
}
