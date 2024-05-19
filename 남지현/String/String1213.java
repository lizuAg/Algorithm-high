import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int test_case=1; test_case<=T; test_case++) {
            bf.readLine();
            char[] target = bf.readLine().toCharArray();
            char[] str = bf.readLine().toCharArray();
            int index = 0;
            int count = 0;
            while (index < str.length) {
                if (str[index] == target[0]) {
                    int cursor=0;
                    while (index<str.length && cursor<target.length && str[index]==target[cursor]) {
                        cursor++;
                        index++;
                    }
                    if (cursor==target.length) {
                        count++;
                    }
                } else {
                    index++;
                }
            }
            StringBuilder builder = new StringBuilder();
            builder.append("#").append(test_case).append(" ").append(count);
            System.out.println(builder);
        }
        bf.close();
    }
}
