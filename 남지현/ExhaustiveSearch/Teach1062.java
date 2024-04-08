import java.util.*;
import java.io.*;

public class Main {
	
	static List<List<Character>> combinations = new ArrayList<>();
	
	private static int solution(int N, int K, List<String> vocas) {
		if (K < 5)
			return 0;
		Set<Character> fixed = Set.of('a', 'c', 'i', 'n', 't');
		Set<Character> added = new HashSet<>();
		List<Set<Character>> letters = new ArrayList<>();
		for (int i=0; i<N; i++) {
			letters.add(new HashSet<>());
			int len = vocas.get(i).length();
			for (int j=4; j<len-4; j++) {
				if (! fixed.contains(vocas.get(i).charAt(j))) {
					letters.get(i).add(vocas.get(i).charAt(j));
					added.add(vocas.get(i).charAt(j));
				}
			}
		}
		if (added.size()==0 || added.size()<=K-5) {
			return vocas.size();
		}
		List<Character> group = new ArrayList<>();
		for (Character c : added) {
			group.add(c);
		}
		for (int i=0; i<group.size(); i++) {
			List<Character> tmp = new ArrayList<>();
			tmp.add(group.get(i));
			combination(i, K-5, group, tmp);
		}
		int answer=0;
		if (combinations.size()==0) {
			for (String str: vocas) {
				List<Character> tmp = new ArrayList<>();
				for (Character c: str.toCharArray()) {
					tmp.add(c);
				}
				if (fixed.containsAll(tmp)) {
					answer++;
				}
			}
			return answer;
		}
		for (List<Character> com: combinations) {
			int count=0;
			for (int i=0; i<N; i++) {
				if (com.containsAll(letters.get(i)))
					count++;
			}
			answer = Math.max(answer, count);
		} 
		return answer;
	}

	private static void combination(int idx, int r, List<Character> group, List<Character> stat) {
		if (r == stat.size()) {
			combinations.add(stat);
			return;
		}
		for (int i=idx+1; i<group.size(); i++) {
			List<Character> tmp = new ArrayList<>();
			for (Character c: stat) {
				tmp.add(c);
			}
			tmp.add(group.get(i));
			combination(i, r, group, tmp);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<String> vocas = new ArrayList<>();
		for (int i=0; i<N; i++) {
			vocas.add(bf.readLine());
		}
		System.out.println(solution(N, K, vocas));
		bf.close();
	}
}
