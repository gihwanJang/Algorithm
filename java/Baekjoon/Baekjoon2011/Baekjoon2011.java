import java.io.*;
import java.util.*;

class Problem {
    private static final int MOD = 1000000;
    private int[] memo;
    private String code;

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        code = br.readLine();
    }

    private void output() {
        System.out.println(solve());
    }

    private int solve() {
        memo = new int[code.length() + 1];
        Arrays.fill(memo, -1);
        return DFS(0);
    }

    private int DFS(int depth) {
        if (depth == code.length()) {
            return 1;
        } else if (memo[depth] != -1) {
            return memo[depth];
        }

        int result = 0;
        
        if (code.charAt(depth) != '0') {
            result = DFS(depth + 1) % MOD;
        }
        if (depth + 1 < code.length()) {
            int twoDigit = Integer.parseInt(code.substring(depth, depth + 2));
            if (10 <= twoDigit && twoDigit <= 26) {
                result = (result + DFS(depth + 2)) % MOD;
            }
        }

        memo[depth] = result;
        return result;
    }
}

public class Baekjoon2011 {
    public static void main(String[] args) {
        new Problem();
    }
}
