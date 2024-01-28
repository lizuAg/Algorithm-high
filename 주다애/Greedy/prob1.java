import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> losts = new ArrayList<>();
        List<Integer> reserves = new ArrayList<>();
        
        for(int i : lost) {
            losts.add(i);
        }
        for(int i : reserve) {
            reserves.add(i);
        }
        
        Collections.sort(losts);
        Collections.sort(reserves);
        
        for(int i = 0 ; i < reserves.size(); i++) {
            // 도난당한 학생은 자기 체육복 입으면 됨
            if(losts.contains(reserves.get(i))) {
                losts.remove(new Integer(reserves.get(i)));
                continue;
            }
            if(losts.contains(reserves.get(i) - 1)) {
                // 도난당한 학생인지 체크
                if(reserves.contains(reserves.get(i) - 1)) {
                    reserves.remove(new Integer(reserves.get(i) - 1));
                }
                losts.remove(new Integer(reserves.get(i) - 1));
                continue;
            }
            if(losts.contains(reserves.get(i) + 1)) {
                // 도난당한 학생인지 체크
                if(reserves.contains(reserves.get(i) + 1)) {
                    reserves.remove(new Integer(reserves.get(i) + 1));
                }
                losts.remove(new Integer(reserves.get(i) + 1));
                continue;
            }
        }
        
        int size = losts.size();
        return n - size;
    }
}
