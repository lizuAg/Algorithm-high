import java.util.*;
import java.io.*;

public class VocaMath1339 {
	
  public static int solution(int N, List<String> numbers) {
    Map<String, Integer> dict = new HashMap<>();
    for (String operand: numbers) {
      String[] letters = operand.split("");
      for (int i=0; i<letters.length; i++) {
        if (! dict.containsKey(letters[i]))
          dict.put(letters[i], (int) Math.pow(10, letters.length-1-i));
        else 
          dict.put(letters[i], dict.get(letters[i]) + (int) Math.pow(10, letters.length-1-i));
      }
    }
    List<Integer> sums = new ArrayList<>();
    for (int val: dict.values()) {
      sums.add(val);
    }
    Collections.sort(sums, Comparator.reverseOrder());
    int digit = 9;
    int answer = 0;
    for (int sum: sums) {
      answer+=sum*digit;
      digit--;
    }
    return answer;
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());
    List<String> arg = new ArrayList<>();
    for (int i=0; i<N; i++) {
      arg.add(bf.readLine());
    }
    System.out.println(solution(N, arg));
  }
}
