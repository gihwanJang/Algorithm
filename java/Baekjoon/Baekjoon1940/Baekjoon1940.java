import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Problem {
    private int n, m;
    private int nums[];

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        solve();
    }

    private void solve() {
        Arrays.sort(nums);

        int count = 0;
        int l = 0;
        int r = n-1;

        while (l < r) {
            if (nums[l] + nums[r] < m) {
                ++l;
            } else if (nums[l] + nums[r] > m) {
                --r;
            } else {
                ++count;
                ++l;
                --r;
            }
        }

        System.out.println(count);
    }
}

public class Baekjoon1940 {
    public static void main(String[] args) {
        new Problem();
    }
}
