import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

class Problem {
    private static final StringBuilder ANSWER = new StringBuilder();

    private int n;
    private int[][] tests;

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
        tests = new int[n][3];
        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tests[i][0] = Integer.parseInt(st.nextToken());
            if (tests[i][0] == 1) {
                tests[i][1] = Integer.parseInt(st.nextToken());
                tests[i][2] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private void solve() {
        int score = 0;
        Deque<int[]> current = new ArrayDeque<>();
        Deque<int[]> stack = new ArrayDeque<>();

        for (int i = 0; i < n; ++i) {
            if (current.size() == 0) {
                if (tests[i][0] == 1) {
                    current.add(tests[i]);
                    score += study(current, stack);
                }
            } else {
                if (tests[i][0] == 1) {
                    stack.add(current.pop());
                    current.add(tests[i]);
                    score += study(current, stack);
                } else {
                    score += study(current, stack);
                }
            }
        }
        ANSWER.append(score);
    }

    private int study(Deque<int[]> current, Deque<int[]> stack) {
        int score = 0;
        current.peek()[2] -= 1;
        if (current.peek()[2] < 1) {
            score += current.pop()[1];
            if (stack.size() > 0) {
                current.add(stack.pollLast());
            }
        }
        return score;
    }

    private void output() {
        System.out.println(ANSWER.toString());
    }
}

public class Baekjoon17952 {
    public static void main(String[] args) {
        new Problem();
    }
}
