import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    
    String paper;
    int len;
    int[] perm;
    boolean[] isSelected;
    
    
    public int solution(String numbers) {
        paper = numbers;
        len = numbers.length();
        perm = new int[len];
        isSelected = new boolean[len];
        
        make(0);
        
        return set.size();
    }
    
    private void make(int idx) {
        if(idx == len)
            return;
        
        for(int i=0; i<len; i++) {
            if(!isSelected[i]) {
                perm[idx] = paper.charAt(i) - '0';
                check(idx+1);
                
                isSelected[i] = true;
                make(idx+1);
                isSelected[i] = false;
            }
        }
    }
    
    private void check(int len) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<len; i++) {
            sb.append(perm[i]);
        }
        
        int num = Integer.parseInt(sb.toString()); 
        
        if(num > 1 && !set.contains(num) && isPrime(num))
            set.add(num);
    }
    
    private boolean isPrime(int num) {
        int sqrt = (int) Math.sqrt(num);
        
        for(int i=2; i<=sqrt; i++) {
            if(num % i == 0)
                return false;
        }
        
        return true;
    }
}
