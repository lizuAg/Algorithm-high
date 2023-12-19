//[프로그래머스] 최소직각사각형(https://school.programmers.co.kr/learn/courses/30/lessons/86491)

class Solution {
    public int solution(int[][] sizes) {
        int width = 0, length = 0;
        
        for(int[] card : sizes){
            //가로 > 세로 ? 회전시키지 않는다.
            if(card[0] > card[1]){
                if(width < card[0])
                    width = card[0];
                if(length < card[1])
                    length = card[1];
            }
            else{//가로 < 세로 ? 회전시킨다.
                if(width < card[1])
                    width = card[1];
                if(length < card[0])
                    length = card[0];
            }
        }
        
        return width * length;
    }
}
