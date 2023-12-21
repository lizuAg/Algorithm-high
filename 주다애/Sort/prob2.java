import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        int len = numbers.length;
        int cnt = 0;
        // 원본과 세자리 수 함께 저장
        ArrayList<Big> arr = new ArrayList<>();
        String answer = "";
        for (int i = 0; i < len; i++) {
            String a = Integer.toString(numbers[i]);
            String threeA = (a + a + a + a).substring(0, 4);
            // 세자리까지만 저장
            int res = Integer.valueOf(threeA);
            arr.add(new Big(numbers[i], res));
        }
        // 컬렉션 정렬
        Collections.sort(arr);
        for (int i = 0; i < len; i++) {
            if (arr.get(i).getOriginal() == 0) {
                cnt++;
            }
            String res = Integer.toString(arr.get(i).getOriginal());
            answer += res;
        }
        if (cnt == len) {
            return "0";
        }
        return answer;
    }
}

class Big implements Comparable<Big>{
    int original;
    int three;
    
    Big(int original, int three) {
        this.original = original;
        this.three = three;
    }
    
    public int getOriginal() {
        return this.original;
    }
    
    @Override
	public int compareTo(Big o) {
        if (o.three != this.three) {
		    return o.three - this.three;                
        }
        return this.original - o.original;
	}
}
