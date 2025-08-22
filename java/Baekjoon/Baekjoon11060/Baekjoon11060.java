import java.io.*;
import java.util.*;

class Problem {
    private int n;
    private int[] maze;
    private int[] memo;

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
        n = Integer.parseInt(br.readLine());
        memo = new int[n];
        maze = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private void output() {
        System.out.println(jump());
    }

    public int jump() {
        if (n == 1) {
            return 0;
        }

        for (int j = 1; j <= maze[0] && j < n; ++j) {
                memo[j] = 1;
        }

        for (int i = 1; i < n; ++i) {
            if (memo[i] != 0) {
                for (int j = 1; j <= maze[i] && i + j < n; ++j) {
                    if (memo[i + j] == 0) {
                        memo[i + j] = memo[i] + 1;
                    } else {
                        memo[i + j] = Math.min(memo[i + j], memo[i] + 1);
                    }
                }
            }
        }
        return memo[n - 1] == 0 ? -1 : memo[n - 1];
    }
}

public class Baekjoon11060 {
    public static void main(String[] args) {
        new Problem();
    }
}
