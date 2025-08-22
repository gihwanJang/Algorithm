import java.io.*;
import java.util.*;

class Problem {
    private int n;
    private int[] candies;

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
        candies = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        solve();
    }

    private void solve() {
        int l = 0;
        int r = 0;
        int kind = 1;
        int count = 1;
        int[] used = new int[10];

        ++used[candies[l]];
        while (r < n - 1) {
            if (used[candies[r+1]] > 0) {
                ++used[candies[++r]];
            } else {
                if (kind == 2) {
                    --used[candies[l]];
                    if (used[candies[l++]] == 0) {
                        --kind;
                    }
                } else {
                    ++used[candies[++r]];
                    ++kind;
                }
            }
            count = Math.max(count, (r - l + 1));
        }
        System.out.println(count);
    }
}

public class Baekjoon30804 {
    public static void main(String[] args) {
        new Problem();
    }
}
