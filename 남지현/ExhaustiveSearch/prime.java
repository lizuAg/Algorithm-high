import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(String numbers) {
        Set<Integer> result = new HashSet<>();
        for (int i = 1; i <= numbers.length(); i++) {
            String[] digits = numbers.split("");
            boolean[] visited = new boolean[numbers.length()];
            String[] arr = new String[i];
            permutation(0, i, digits, arr, visited, result);
        }
        List<Integer> primes = result.stream().filter(n -> isPrime(n)).collect(Collectors.toList());
        return primes.size();
    }
    private void permutation(
        int depth, 
        int len, 
        String[] sample, 
        String[] arr, 
        boolean[] visited, 
        Set<Integer> result
    ) {
        if (depth == len) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < len; i++) {
                builder.append(arr[i]);
            }
            result.add(Integer.valueOf(builder.toString()));
            return;
        }
        for (int i = 0; i < sample.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = sample[i];
                permutation(depth + 1, len, sample, arr, visited, result);
                visited[i] = false;
            }
        }
    }
    
    private boolean isPrime(int n) {
        if (n ==0 || n == 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
