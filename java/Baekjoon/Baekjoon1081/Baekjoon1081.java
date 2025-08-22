import java.io.*;
import java.util.*;

class Problem {
    private long l,u;

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Long.parseLong(st.nextToken());
        u = Long.parseLong(st.nextToken());
    }

    private void output() {
        System.out.println(sum(u) - sum(l - 1));
    }

    private long sum(long n) {
        if (n <= 0) {
            return 0;
        }
        long s = 1, sum = 0, t, r;
        long[] c = new long[10];

        Arrays.fill(c, 0);
        while (n > 0) {
            t = n / (s * 10);
            r = n % (s * 10);
            for (int i = 0; i < 10; ++i) {
                c[i] += t * s;
            }
            for (int i = 1; i <= r / s; ++i) {
                c[i] += s;
            }
            c[(int)((r / s + 1) % 10)] += r % s;
            n -= 9 * s;
            s *= 10;
        }

        for (int i = 1; i < 10; ++i) {
            sum += i * c[i];
        }
        return sum;
    }
}

public class Baekjoon1081 {
    public static void main(String[] args) {
        new Problem();
    }
}
