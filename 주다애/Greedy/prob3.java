class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        char[] arr = number.toCharArray();
        int t = number.length() - k;
        // 뒤에서부터 t-1자리 남겨놓고 최대값 정하기 
        for(int i = 0; i < t; i++) {
            char max = '0';
            for(int j = idx; j <= i + k; j++) {
                if(arr[j] > max) {
                    max = arr[j];
                    idx = j + 1;
                }
            }
            sb.append(max);
        }
        // 테스트 케이스 10번 시간 초과 때문
        return sb.toString();
    }
}
