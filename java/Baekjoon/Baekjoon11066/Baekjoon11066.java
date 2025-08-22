import java.io.*;
import java.util.*;

class Problem {
    int n;
    int[] files, sum;
    int[][] dp;

    public Problem(int n) {
        this.n = n;
        sum = new int[n+1];
        files = new int[n+1];
        dp = new int[n+1][n+1];
    }

    public int solve() {
        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j+i <= n; ++j) {
                dp[j][i+j] = Integer.MAX_VALUE;
                for(int k = j; k < i+j; ++k) {
                    dp[j][i+j] = Math.min(dp[j][i+j], dp[j][k] + dp[k+1][i+j] + sum[i+j] - sum[j-1]);
                }
            }
        }
        
        return dp[1][n];
    }
}

public class Baekjoon11066 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; ++t) {
            Problem problem = new Problem(Integer.parseInt(br.readLine()));
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 1; i <= problem.n; ++i) {
                problem.files[i] = Integer.parseInt(st.nextToken());
                problem.sum[i] = problem.sum[i-1] + problem.files[i];
            }

            sb.append(problem.solve()).append("\n");
        }

        System.out.print(sb.toString());
    }
}
