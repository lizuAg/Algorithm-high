import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 부분 문자열(브룐즈 2)
// 1. contains -> 26%에서 시간초과
// 2. KMP Algorithm -> O(N + M)
public class BaekJoon16916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String p = br.readLine();
        System.out.println(KMP(s, p));
    }

    private static int KMP(String original, String compare) {
        int oLen = original.length();
        int cLen = compare.length();
        int[] table = makeTable(compare);
        int idx = 0;
        for(int i = 0; i < oLen; i++) {
            while(idx > 0 && original.charAt(i) != compare.charAt(idx)) {
                idx = table[idx - 1];
            }
            if(original.charAt(i) == compare.charAt(idx)) {
                if(idx == cLen - 1) {
                    idx = table[idx];
                    return 1;
                }
                else {
                    idx += 1;
                }
            }
        }
        return 0;
    }

    private static int[] makeTable(String compare) {
        int n = compare.length();
        int[] table = new int[n];

        int idx = 0;
        for(int i = 1; i < n; i++) {
            while(idx > 0 && compare.charAt(i) != compare.charAt(idx)) {
                idx = table[idx - 1];
            }
            if(compare.charAt(i) == compare.charAt(idx)) {
                idx += 1;
                table[i] = idx;
            }
        }
        return table;
    }
}
