import java.io.*;
import java.util.Arrays;

class Problem {
    private static final StringBuilder ANSWER = new StringBuilder();

    private int c, k;

    public Problem() {
        try {
            input();
            solve();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] in = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        c = in[0];
        k = in[1];
    }

    private void solve() {
        int pow = (int)Math.pow(10, k);
        double tmp = c;
        ANSWER.append(Math.round(tmp / pow) * pow);
    }

    private void output() {
        System.out.println(ANSWER.toString());
    }
}

public class Baekjoon2909 {
    public static void main(String[] args) {
        new Problem();
    }
}