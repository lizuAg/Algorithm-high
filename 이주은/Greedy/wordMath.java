import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int [] alpha = new int[27];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        ArrayList<String> wordList = new ArrayList<>();

        for (int i = 0; i < n; i++)
            wordList.add(br.readLine());

        for(String word: wordList) {
            for(int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                alpha[c-'A'] += (int) Math.pow(10, word.length() - i -1);
            }
        }
        Arrays.sort(alpha);

        int answer = 0;
        int weight = 9;
        for(int i=26; i>= 0; i--) {
            if(alpha[i] == 0)
                break;
            answer += alpha[i]*weight;
            weight--;
        }
        System.out.println(answer);
    }
}
