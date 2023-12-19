//[프로그래머스] 가장 큰 수(https://school.programmers.co.kr/learn/courses/30/lessons/42746)

import java.util.ArrayList;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        ArrayList<String> list = new ArrayList<>();
        String answer ="";
        
        for(int num : numbers)
            list.add(Integer.toString(num));
        
        list.sort(new StringNumberComparator().reversed());
        for(String num: list){
            answer +=num;
        }

        return answer.startsWith("0") ? "0" : answer;
    }
}

class StringNumberComparator implements Comparator<String> {
    @Override
    public int compare(String str, String another) {
        String str1 = str+another;
        String str2 = another+str;
        return str1.compareTo(str2);
    }
}
