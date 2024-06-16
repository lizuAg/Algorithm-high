import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people); // 오름차순 정렬
        int last = people.length;
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = last - 1;
        while(i < j) {
            int w = people[i];
            int s = people[j];
            if(w + s <= limit) {
                answer++;
                i++;
                list.add(s);
                list.add(w);
            }
            j--;
        }
        int size = list.size();
        return answer + (last - size);
    }
}
