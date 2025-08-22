import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

class Problem {
    private static final StringBuilder OUT = new StringBuilder();

    private int n;
    private int[][] condo;

    public Problem() {
        try {
            input();
            solve();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        condo = new int[n][2];
        for (int i = 0; i < n; ++i) {
            condo[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    private void solve() {
        int x = 0;
        for (int i = 0; i < n; ++i) {
            x += isX(i) ? 1 : 0;
        }
        OUT.append(x);
    }

    private boolean isX(int target) {
        for (int i = 0; i < n; ++i) {
            if (target == i) continue;
            if (condo[i][0] < condo[target][0]) {
                if (!(condo[i][1] > condo[target][1])) {
                    return false;
                }
            }
            if (condo[i][1] < condo[target][1]) {
                if (!(condo[i][0] > condo[target][0])) {
                    return false;
                }
            }
        }
        return true;
    }

    private void output() {
        System.out.println(OUT.toString());
    }
}

public class Baekjoon2246 {
    public static void main(String[] args) {
        new Problem();
    }
}
