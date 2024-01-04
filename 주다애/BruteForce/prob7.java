class Solution {
    static int count = 0;
    static int answer;
    static char[] path = new char[6];
    static char[] words = {'A', 'E', 'I', 'O', 'U'};
    static String t;
    public int solution(String word) {
        t = word;
        run(0);
        return answer;
    }
    
    public void run(int level) {
        String tar = "";
        for(int i = 0; i < level; i++) {
            tar += path[i];
        }
        // 타겟 문자와 같은지 확인
        if(tar.equals(t)) {
            answer = count;
            return;
        }
        
        if(level == 5) {
            return;
        }
        for(int i = 0; i < 5; i++) {
            path[level] = words[i];
            count++;
            run(level + 1);
            path[level] = 0;
        }
        
    }
}
