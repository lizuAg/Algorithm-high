import java.util.*;
class Solution {
    public String solution(String number, int k) {
        int len = number.length();
        StringBuilder builder = new StringBuilder(number.substring(0, len-k));
        for (int end=len-k; end<len; end++) {
            builder.append(number.charAt(end));
            int idx = -1;
            int n = builder.length();
            for (int i=0; i<n-1; i++) {
                if (builder.charAt(i) < builder.charAt(i+1)) {
                    idx = i;
                    break;
                }
                idx = n-1;
            }
            builder.deleteCharAt(idx);
        }
        return builder.toString();
    }
}
