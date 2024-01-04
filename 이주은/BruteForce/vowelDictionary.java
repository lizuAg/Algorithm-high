class Solution {
    static StringBuilder sb = new StringBuilder();
    static char[] alphabet= {'A', 'E', 'I', 'O', 'U'};
    int index = 0;
    
    public int solution(String word) {
        //dfs로 만들어지는 문자열과 순서가 동일하다.
        return findWord(word, "");
    }
    
    public static int findWord(String target, String str) {
        if(str.equals(target)){
           return index;
        }

        if(str.length() < 5)
            for(char c : alphabet){
                if(sb.toString().equals(target)){
                    return index;
                }
                if(str.length()>1)
                    sb.deleteCharAt(str.length()-1);
                sb.append(c);
                index = findWord(target, sb.toString(), ++index);
            }
        
        return index;
    }
}
