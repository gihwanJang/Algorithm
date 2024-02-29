import java.io.*;
import java.util.*;

class Problem {
    private int n;
    private int[][] dp;

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
        this.dp = new int[11][11];
        Arrays.fill(dp[0], 1);
    }

    private void output() {
        System.out.println(solve());
    }

    private long solve() {
        if (1022 < n) {
            return -1;
        }

        for (int i = 1; i < 10; ++i) {
            for (int j = i; j < 10; ++j) {
                for (int k = i-1; k < j; ++k) {
                    dp[i][j] += dp[i-1][k];
                }
            }
        }
        for (int i = 0; i < 10; ++i) {
            for (int j = i + 1; j < 10; ++j) {
                dp[i][j] += dp[i][j-1];
            }
            dp[i+1][i+1] += dp[i][9];
        }
        return makeAnswer();
    }

    private long makeAnswer() {
        for (int i = 0; i < 10; ++i) {
            for (int j = i; j < 10; ++j) {
                if (n + 1 < dp[i][j]) {
                    if (i == j) {
                        return makeAnswer(j, i, dp[i - 1][9]);
                    } else {
                        return makeAnswer(j, i, dp[i][j - 1]);
                    }
                } else if (n + 1 == dp[i][j]) {
                    long ans = 0;
                    for (int k = i; k >= 0; --k) {
                        ans *= 10;
                        ans += j--;
                    }
                    return ans;
                }
            }
        }
        return -1;
    }

    private long makeAnswer(int front, int len, int seq) {
        long ans = 0;
        int[] nums = new int[len + 1];

        nums[len] = front;
        for (int i = 0; i < len; ++i) {
            nums[i] = i;
        }
        while (seq++ < n) {
            int flag = len -1;
            for (int i = 0; i < len - 1; ++i) {
                if (nums[i] + 1 != nums[i + 1]) {
                    ++nums[i];
                    flag = i;
                    break;
                }
            }
            if (flag == len -1) {
                ++nums[len - 1];
            }
            for (int i = 0; i < flag; ++i) {
                nums[i] = i;
            }
        }
        for (int i = len; i >= 0; --i) {
            ans *= 10;
            ans += nums[i];
        }
        return ans;
    }
}

public class Baekjoon1038 {
    public static void main(String[] args) {
        new Problem();
    }
}
/*
 * 0 - 0
 * 1 - 1
 * 2 - 2
 * ...
 * 9 - 9
 * 10 - 10
 * 
 * 11 - 20
 * 12 - 21
 * 
 * 13 - 30
 * 14 - 31
 * 15 - 32
 * 
 * 16 - 40
 * 17 - 41
 * 18 - 42
 * 19 - 43
 */