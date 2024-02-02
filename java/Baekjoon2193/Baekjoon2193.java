import java.io.*;
import java.util.*;

class Problem {
    private int n;
    private long[][] memo;

    public Problem() {
        input();
        output();
    }

    private long solve(int idx, int num) {
        if (idx == n - 1) {
            return 1;
        } else if (memo[idx][num] != -1) {
            return memo[idx][num];
        }

        long zero = solve(idx + 1, 0);
        long one = (num == 1) ? 0 : solve(idx + 1, 1);
        return memo[idx][num] = zero + one;
    }

    private void output() {
        System.out.println(solve(0, 1));
    }

    private void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            memo = new long[n][2];
            for (int i = 0; i < n; ++i) {
                Arrays.fill(memo[i], -1);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}

public class Baekjoon2193 {
    public static void main(String[] args) {
        new Problem();
    }
}
