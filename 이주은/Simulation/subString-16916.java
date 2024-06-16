//백준 16916번 부분 문자열

import java.util.*;
import java.io.*;

class Main {
    static String S, P;
    static int[] table;
    
    public static void main(String[] args) throws IOException {
        getInput();
        makeTable();
        System.out.println(KMP());
    }

    static int KMP() {
        int sLen = S.length();
        int pLen = P.length();

        int j=0;
        for(int i=0; i<sLen; i++) {
            while(j > 0 && S.charAt(i) != P.charAt(j)) {
                j = table[j-1];
            }

            if(S.charAt(i) == P.charAt(j)) {
                if(j == pLen-1)
                    return 1;
                else
                    j++;
            }
        }
        return 0;
    }

    static void makeTable() {
        int len = P.length();
        table = new int[len];

        int j = 0;
        for(int i=1; i<len; i++) {
            while(j>0 && P.charAt(i) != P.charAt(j)) {
                j = table[j-1];
            }

            if(P.charAt(i) == P.charAt(j)) {
                table[i] = ++j;
            }
        }
    }
    
    static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        P = br.readLine();
    }
}
