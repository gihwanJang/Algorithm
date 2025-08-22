import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

class Problem {
    private int N, M;
    private long K;
    private long[][] memo;

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

        this.N = Integer.parseInt(st.nextToken());
        this.M = Integer.parseInt(st.nextToken());
        this.K = Long.parseLong(st.nextToken());
        this.memo = new long[N + M + 1][N + M + 1];
        IntStream.rangeClosed(0, N + M).forEach(i -> Arrays.fill(memo[i], -1));
    }

    private void output() {
        if (comb(N + M, N) < K) {
            System.out.println("-1");
        } else {
            go(N, M, K);
            System.out.println();
        }
    }

    private long comb(int n, int r) {
        if (n == r || r <= 0) {
            return 1;
        } else if (memo[n][r] != -1) {
            return memo[n][r];
        }

        long ret1 = 0, ret2 = 0;

        ret1 = comb(n - 1, r - 1);
        ret2 = comb(n - 1, r);
        if (ret1 + ret2 > 1000000000) {
            return memo[n][r] = 1000000001;
        } else {
            return memo[n][r] = ret1 + ret2;
        }
    }
    
    private void go(int n, int m, long k) {
        long c = comb(n + m - 1, n - 1);
        if (n > 0 && k <= c) {
            System.out.print('a');
            go(n - 1, m, k);
        } else if (m > 0) {
            System.out.print('z');
            go(n, m - 1, k - c);
        }
    }
}

public class Baekjoon1256 {
    public static void main(String[] args) {
        new Problem();
    }
}
