//[프로그래머스] 숫자 문자열과 영단어(https://school.programmers.co.kr/learn/courses/30/lessons/81301)

class Solution {
    public int solution(String s) {
        String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] word = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < 10; i++) {
            s = s.replace(word[i], num[i]);
        }
        return Integer.parseInt(s);
    }
}
