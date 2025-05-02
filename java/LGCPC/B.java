import java.io.*;
import java.util.*;

class Problem {
    private int n, k;
    private long[][][] sum;
    private StringBuilder sb;

    public Problem() {
        sb = new StringBuilder();
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int T = Integer.parseInt(br.readLine()); T > 0; --T) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            sum = new long[2][n+1][2];

            int[] c = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            long[] w = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            for (int i = 0; i < n; ++i) {
                sum[0][i+1][0] = sum[0][i][0] + (c[i] == 1 ? 1 : 0);
                sum[0][i+1][1] = sum[0][i][1] + (c[i] == 2 ? 1 : 0);
                sum[1][i+1][0] = sum[1][i][0] + (c[i] == 1 ? w[i] : 0);
                sum[1][i+1][1] = sum[1][i][1] + (c[i] == 2 ? w[i] : 0);
            }
            sb.append(solve()).append("\n");
        }
    }

    public int solve() {
        int count = 0;

        for (int i = 1; i <= n; ++i) {
            for (int j = i; j <= n; ++j) {
                long sum1 = sum[1][j][0] - sum[1][i-1][0];
                long sum2 = sum[1][j][1] - sum[1][i-1][1];
                long c1Count = sum[0][j][0] - sum[0][i-1][0];
                long c2Count = sum[0][j][1] - sum[0][i-1][1];

                if (c1Count == c2Count && Math.abs(sum1 - sum2) <= k) {
                    ++count;
                }
            }
        }
        return count;
    }

    private void output() {
        System.out.print(sb.toString());
    }
}

public class B {
    public static void main(String[] args) {
        new Problem();
    }
}
