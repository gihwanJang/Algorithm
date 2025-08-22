import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Problem {
    private static final StringBuilder ANSWER = new StringBuilder();
    private int n, m;
    private int[] nums;
    private int[][] queries;

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

        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[n+1];
        for (int i = 0; i < n; ++i) {
            nums[i + 1] = nums[i] + Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());

        queries = new int[m][2];
        for (int i = 0; i < m; ++i) {
            queries[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    private void solve() {
        for (int[] query : queries) {
            ANSWER.append(nums[query[1]] - nums[query[0]-1]).append("\n");
        }
    }

    private void output() {
        System.out.print(ANSWER.toString());
    }
}

public class Baekjoon1141 {
    public static void main(String[] args) {
        new Problem();
    }
}
