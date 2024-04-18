import java.util.*;
import java.io.*;

public class Main {
	
	static List<String> vocas;
	static List<List<Character>> combinations = new ArrayList<>();
	static boolean[] visited = new boolean[26];
	static int flag;
	static int max;
	
	private static int solution3(int N, int K) {		
		if (K<5) {
			max = 0;
		} else if (K == 26) {
			max = N;
		} else {
			flag=0;
			max=0;
			flag |= 1<<('a'-'a');
			flag |= 1<<('c'-'a');
			flag |= 1<<('i'-'a');
			flag |= 1<<('n'-'a');
			flag |= 1<<('t'-'a');
			bitmasking(N, K, 0, 0);
		}
		return max;
	}
	
	private static void bitmasking(int N, int K, int start, int depth) {
		if (depth == K-5) {
			int count=0;
			for (int i=0; i<N; i++) {
				boolean readable = true;
				for (char c: vocas.get(i).toCharArray()) {
					if ((flag & 1<<(c-'a')) == 0) {
						readable = false;
						break;
					}
				}
				if (readable)
					count++;
			}
			max = Math.max(max, count);
			return;
		}
		for (int i=start; i<26; i++) {
			if ((flag & 1<<i) == 0) {
				flag |= 1<<i;
				bitmasking(N, K, i, depth+1);
				flag &= ~(1<<i);
			}
		}
	}
	
	private static int solution2(int N, int K) {
		max=0;
		visited['a'-'a'] = true;
		visited['c'-'a'] = true;
		visited['i'-'a'] = true;
		visited['n'-'a'] = true;
		visited['t'-'a'] = true;
		
		if (K < 5) {
			return 0;
		} else {
			backtracking(N, K, 0, 0);
		}	
		return max;
	}
	
	private static void backtracking(int N, int K, int idx, int depth) {
		if (depth == K-5) {
			int count = 0;
			for (int i=0; i<N; i++) {
				boolean readable = true;
				for (char c: vocas.get(i).toCharArray()) {
					if (! visited[c-'a']) {
						readable = false;
						break;
					}
				}
				if (readable) count++;
			}
			max = Math.max(max, count);
		}
		
		for (int i=idx; i<26; i++) {
			if (! visited[i]) {
				visited[i] = true;
				backtracking(N, K, i, depth+1);
				visited[i] = false;
			}
		}
	}
	
	
	private static int solution(int N, int K) {
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
		vocas = new ArrayList<>();
		for (int i=0; i<N; i++) {
			vocas.add(bf.readLine());
		}
		System.out.println(solution(N, K));
		System.out.println(solution2(N, K));
		System.out.println(solution3(N, K));
		bf.close();
	}
}
