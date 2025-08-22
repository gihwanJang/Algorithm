import java.io.*;
import java.util.*;

class Problem {
    private int n;
    private int[] nums;

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        solve();
    }

    private void solve() {
        Arrays.sort(nums);
        int count = 0;

        for (int i = 0; i < n; ++i) {
            int l = 0;
            int r = n-1;
            while (l < r) {
                if (l == i || nums[l] + nums[r] < nums[i]) {
                    ++l;
                } else if (r == i || nums[l] + nums[r] > nums[i]) {
                    --r;
                } else {
                    ++count;
                    break;
                }
            }
        }


        System.out.println(count);
    }
}

public class Baekjoon1253 {
    public static void main(String[] args) {
        new Problem();
    }
}


