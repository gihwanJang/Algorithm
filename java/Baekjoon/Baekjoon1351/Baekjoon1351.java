import java.io.*;
import java.util.*;

class Problem {
    HashMap<Long, Long> memo;
    long n, p, q;

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        p = Long.parseLong(st.nextToken());
        q = Long.parseLong(st.nextToken());
        memo = new HashMap<>();
    }

    private void output() {
        System.out.println(solve(n));
    }

    private long solve(long idx) {
        if (idx == 0) {
            return 1;
        } else if (memo.containsKey(idx)) {
            return memo.get(idx);
        }
        memo.put(idx, solve(idx/p) + solve(idx/q));
        return memo.get(idx);
    }
}

public class Baekjoon1351 {
    public static void main(String[] args) {
        new Problem();
    }
}
