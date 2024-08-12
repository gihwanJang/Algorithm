import java.io.*;
import java.util.*;

class Problem {
    private int n, m;
    private int[] coins;
    private int[] memo;
    private StringBuilder sb;

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = Integer.parseInt(br.readLine()); t > 0; --t) {
            n = Integer.parseInt(br.readLine());
            coins = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            m = Integer.parseInt(br.readLine());
            memo = new int[m + 1];

            sb.append(solve()).append("\n");
        }
    }

    private void output() {
        System.out.print(sb.toString());
    }

    private int solve() {
        memo[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= m; j++) {
                memo[j] += memo[j - coin];
            }
        }
        return memo[m];
    }
}

public class Baekjoon9084 {
    public static void main(String[] args) {
        new Problem();
    }
}
