import java.io.*;

class Problem {
    final int mod = 1_000_000_009, max = 100000;
    long[][] dp;
    public Problem() {
        dp = new long[max+1][4];
        dp[1][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;
        for (int i = 4; i <= max; ++i) {
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % mod;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % mod;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % mod;
        }
    }
    public long solve(int n) {
        return (dp[n][1] + dp[n][2] + dp[n][3]) % mod;
    }
}

public class Baekjoon15990 {
    public static void main(String[] args) throws Exception {
        Problem p = new Problem();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t > 0; --t) {
            sb.append(p.solve(Integer.parseInt(br.readLine()))).append("\n");
        }
        System.out.print(sb.toString());
    }
}
