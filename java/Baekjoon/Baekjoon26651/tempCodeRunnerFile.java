import java.io.*;
import java.util.*;

class Problem {
    private static final StringBuilder ANSWER = new StringBuilder();
    private static final StringBuilder GRAM_STRING = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    private static final String NOT_GRAM_STRING = "GBSISTHEBEST";

    private int n;

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
    }

    private void solve() {
        if (n ==0) {
            ANSWER.append(NOT_GRAM_STRING);
            return;
        }
        int l = 1;
        int r = 1;
        int sqrt = ((int) Math.sqrt(n)) + 1;
        StringBuilder leftStringBuilder = new StringBuilder();
        StringBuilder rightStringBuilder = new StringBuilder();

        for (int i = sqrt; i > 0; --i) {
            if (n % i == 0) {
                l = i;
                r = n / i;
                break;
            }
        }

        for (int i = 1; i < l; ++i) {
            leftStringBuilder.append('A');
        }
        for (int i = 1; i < r; ++i) {
            rightStringBuilder.append('Z');
        }
        ANSWER.append(leftStringBuilder.toString()).append(GRAM_STRING).append(rightStringBuilder.toString());
    }

    private void output() {
        System.out.println(ANSWER.toString());
    }
}

public class Baekjoon26651 {
    public static void main(String[] args) {
        new Problem();
    }
}
