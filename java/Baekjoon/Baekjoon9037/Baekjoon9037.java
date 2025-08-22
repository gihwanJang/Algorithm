import java.io.*;
import java.util.*;

class Problem {
    private static final StringBuilder SB = new StringBuilder();

    private int n;
    private int[] c;

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
            n = Integer.parseInt(br.readLine());
            c = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            solve();
        }
        System.out.print(SB.toString());
    }

    private void solve() {
        int cnt = 0;
        makeEven();
        for (; !isSame(); ++cnt) {
            int num = c[0];
            for (int i = 0; i < n; ++i) {
                int next = (i + 1) % n;
                int p = num / 2;
                num = c[next];
                c[next] += p;
                c[i] -= p;
            }
            makeEven();
        }
        SB.append(cnt).append('\n');
    }

    private void makeEven() {
        for (int i = 0; i < n; ++i) {
            c[i] += c[i] % 2 == 1 ? 1 : 0;
        }
    }

    private boolean isSame() {
        for (int i = 1; i < n; ++i) {
            if (c[i-1] != c[i]) {
                return false;
            }
        }
        return true;
    }
}

public class Baekjoon9037 {
    public static void main(String[] args) {
        new Problem();
    }
}
