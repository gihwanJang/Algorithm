import java.io.*;
import java.util.*;

class Problem {
    private int n;
    private int[] nums;

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
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private String solve() {
        StringBuilder sb = new StringBuilder();
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty()) {
                if (stack.peek()[1] > nums[i]) {
                    sb.append(stack.peek()[0]);
                    break;
                }
                stack.pop();
            }

            if (stack.isEmpty()) {
                sb.append(0);
            }
            stack.push(new int[]{i + 1, nums[i]});
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void output() {
        System.out.println(solve());
    }
}

public class Baekjoon2493 {
    public static void main(String[] args) {
        new Problem();
    }
}
