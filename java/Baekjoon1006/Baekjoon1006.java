import java.io.*;
import java.util.*;

class Problem {
    private static final StringBuilder SB = new StringBuilder();

    private int n;
    private int w;
    private int[][] dp;
    private int[][] sections;

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = Integer.parseInt(br.readLine()); t > 0; --t) {
            int[] nw = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = nw[0];
            w = nw[1];
            sections = new int[2][];
            for (int i = 0; i < 2; ++i) {
                sections[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            
            dp = new int[n+1][3];
            dp[0][0] = 1;
            dp[0][1] = 1;
            dp[0][2] = 0;
            solve(0);

            int res = dp[n][2];

            if (n > 1) {
                /*
                 * -xxx-
                 * -xxx-
                 */
                if (sections[0][0] + sections[0][n-1] <= w && sections[1][0] + sections[1][n-1] <= w) {
                    dp[1][0] = 1;
                    dp[1][1] = 1;
                    dp[1][2] = 0;
                    solve(1);
                    res = Math.min(res, dp[n-1][2] + 2);
                }

                /*
                 * -xxx-
                 * --xxx
                 * 
                 * -xxx-
                 * *xxxx
                 */
                if (sections[0][0] + sections[0][n-1] <= w) {
                    dp[1][0] = 2;
                    dp[1][1] = sections[1][0] + sections[1][1] > w ? 2 : 1;
                    dp[1][2] = 1;
                    solve(1);
                    res = Math.min(res, dp[n-1][1] + 1);
                }

                /*
                 * --xxx
                 * -xxx-
                 * 
                 * *xxxx
                 * -xxx-
                 */
                if (sections[1][0] + sections[1][n-1] <= w) {
                    dp[1][0] = sections[0][0] + sections[0][1] > w ? 2 : 1;
                    dp[1][1] = 2;
                    dp[1][2] = 1;
                    solve(1);
                    res = Math.min(res, dp[n-1][0] + 1);
                }
            }
            SB.append(res).append("\n");
        }
        System.out.print(SB.toString());
    }

    private void solve(int idx) {
        for (int i = idx; i < n; ++i) {
            dp[i+1][2] = Math.min(dp[i][0] + 1, dp[i][1] + 1);

            /*
             * *|
             * *|
             */
            if (sections[0][i] + sections[1][i] <= w) {
                dp[i + 1][2] = Math.min(dp[i + 1][2], dp[i][2] + 1);
            }


            /*
             * --
             * --
             */
            if (i > 0 && sections[0][i - 1] + sections[0][i] <= w && sections[1][i - 1] + sections[1][i] <= w) {
                dp[i+1][2] = Math.min(dp[i+1][2], dp[i - 1][2] + 2);
            }

            if (i < n-1) {
                dp[i + 1][0] = dp[i + 1][2] + 1;
                dp[i + 1][1] = dp[i + 1][2] + 1;

                /*
                 * --
                 * *
                 */
                if (sections[0][i] + sections[0][i+1] <= w) {
                    dp[i+1][0] =  Math.min(dp[i + 1][0], dp[i][1] + 1);
                }

                /*
                 * *
                 * --
                 */
                if (sections[1][i] + sections[1][i+1] <= w) {
                    dp[i+1][1] =  Math.min(dp[i + 1][1], dp[i][0] + 1);
                }
            }
        }
    }
}

public class Baekjoon1006 {
    public static void main(String[] args) {
        new Problem();
    }
}
