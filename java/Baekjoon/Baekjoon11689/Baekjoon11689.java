import java.io.*;

class Problem {
    long n;

    public Problem(long n) {
        this.n = n;
    }

    public long solve() {
        long pi = n;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                pi = pi / i * (i - 1);
            }
            while (n % i == 0) {
                n /= i;
            }
        }
        if (n != 1) {
            pi = pi / n * (n - 1);
        }
        return pi;
    }
}

public class Baekjoon11689 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem problem = new Problem(Long.parseLong(br.readLine()));
        System.out.println(problem.solve());
    }
}