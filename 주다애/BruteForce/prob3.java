import java.util.*;

class Solution {
    HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        recursion("", numbers);
        // 소수 찾기
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()) {
            int num = it.next();
            if(isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }
    
    public void recursion(String num, String remain) {
        if(!num.equals("")) {
            set.add(Integer.valueOf(num));
        }
        if(remain.equals("")) return;
        for(int i = 0; i < remain.length(); i++) {
            recursion(num + remain.charAt(i), remain.substring(0, i) + remain.substring(i+1));
        }
    }
    
    public boolean isPrime(int num) {
        // 0, 1
        if(num == 0  || num == 1) return false;
        // 에라토스테네스 채의 limit
        int limit = (int) Math.sqrt(num);
        for(int i = 2; i <= limit; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
