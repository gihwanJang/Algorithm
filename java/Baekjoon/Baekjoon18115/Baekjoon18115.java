import java.io.*;
import java.util.*;

class Problem {
    int n;
    int[] ans;
    int[] nums;

    public Problem() {
        input();
        output();
    }

    private void solve() {
        int first = 0;
        int second = 1;
        int last = n - 1;

        for (int i = 0; i < nums.length; ++i, --n) {
            if (nums[i] == 1) {
                ans[first] = n;
                first = second;
                second = first + 1;
            } else if (nums[i] == 2) {
                ans[second] = n;
                ++second;
            } else {
                ans[last] = n;
                --last;
            }
        }
    }

    private void input() {
        try {
            StringTokenizer st;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            n = Integer.parseInt(br.readLine());
            ans = new int[n];
            nums = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; ++i) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void output() {
        StringBuilder sb = new StringBuilder();

        solve();
        for (int i = 0; i < ans.length; ++i) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb.toString());
    } 
}

public class Baekjoon18115 {
    public static void main(String[] args) {
        new Problem();
    }
}
