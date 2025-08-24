import java.io.*;
import java.util.*;

class Problem {
    private static final StringBuilder ANSWER = new StringBuilder();

    private int t;
    private int[][] chickens;

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
        t = Integer.parseInt(br.readLine());
        chickens = new int[t][2];
        for (int i = 0; i < t; ++i) {
            chickens[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    private void solve() {
        for (int[] c : chickens) {
            int cut = 2*c[1] - c[0];
            ANSWER.append(cut).append(" ").append(c[1] - cut).append("\n");
        }
    }

    private void output() {
        System.out.print(ANSWER.toString());
    }
}

public class Baekjoon11006 {
    public static void main(String[] args) {
        new Problem();
    }
}
