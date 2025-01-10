import java.io.*;
import java.util.Arrays;

class Problem {
    private int[] nld;

    public Problem() {
        try {
            input();
            solve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nld = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private void solve() {
        int i = nld[1];
        int total = nld[0] * nld[1] + 5 * (nld[0] - 1);
        for (; i < total; i += nld[1]) {
            for (int j = 0; j < 5; ++j, ++i) {
                if (i % nld[2] == 0) {
                    System.out.println(i);
                    return;
                }
            }
        }
        for (; ; ++i) {
            if (i % nld[2] == 0) {
                System.out.println(i);
                return;
            }
        }
    }
}

public class Baekjoon1333 {
    public static void main(String[] args) {
        new Problem();
    }
}
