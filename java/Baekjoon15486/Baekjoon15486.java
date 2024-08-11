import java.io.*;

class Problem {
    private int n;
    private int[] dp;
    private int[][] jobs;

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
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        jobs = new int[n][2];
        for (int i = 0; i < n; ++i) {
            String[] read = br.readLine().split(" ");
            jobs[i][0] = Integer.parseInt(read[0]);
            jobs[i][1] = Integer.parseInt(read[1]);
        }
    }

    private void output() {
        System.out.println(solve());
    }

    private int solve() {
        for (int i = n - 1; i >= 0; --i) {
            dp[i] = dp[i + 1];
            if (i + jobs[i][0] <= n) {
                dp[i] = Math.max(dp[i], dp[i + jobs[i][0]] + jobs[i][1]);
            }
        }
        return dp[0];
    }
}

public class Baekjoon15486 {
    public static void main(String[] args) {
        new Problem();
    }
}
