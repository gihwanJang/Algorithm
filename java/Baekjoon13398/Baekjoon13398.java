import java.io.*;
import java.util.*;

class Problem {
    private int n;
    private int[] nums;
    private int[] leftSum;
    private int[] rightSum;

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        this.n = Integer.parseInt(br.readLine());
        this.leftSum = new int[n];
        this.rightSum = new int[n];
        this.nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(i -> Integer.parseInt(i))
                .toArray();
    }

    private void output() {
        System.out.println(solve());
    }

    private int solve() {
        if (n == 1) {
            return nums[0];
        }
        int ret = leftSum[0] = nums[0];

        for (int i = 1; i < n; ++i) {
            leftSum[i] = Math.max(nums[i], nums[i] + leftSum[i - 1]);
            ret = Math.max(ret, leftSum[i]);
        }
        rightSum[n-1] = nums[n-1];
        for (int i = n - 2; i >= 0; --i) {
            rightSum[i] = Math.max(nums[i], nums[i] + rightSum[i + 1]);
        }
        for (int i = 1; i < n - 1; ++i) {
            ret = Math.max(ret, leftSum[i - 1] + rightSum[i + 1]);
        }
        return ret;
    }
}

public class Baekjoon13398 {
    public static void main(String[] args) {
        new Problem();
    }
}