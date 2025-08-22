import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Problem {
    private static final StringBuilder SB = new StringBuilder();
    private int n;
    private int[] solved;

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
        solved = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private void solve() {
        int d = 0, c = 0;
        boolean useable = true;
        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            if (!useable) {
                if (d == 1) {
                    useable = true;
                    d = 0;
                } else {
                    ++d;
                }
            }

            if (solved[i] != 0) {
                ++c;
            } else {
                if (useable) {
                    useable = false;
                } else {
                    nums.add(c);
                    c = 0;
                }
            }
        }

        nums.add(c);
        Collections.sort(nums);
        Collections.reverse(nums);
        SB.append(nums.get(0));
    }

    private void output() {
        System.out.println(SB.toString());
    }
}

public class Baekjoon30395 {
    public static void main(String[] args) {
        new Problem();
    }
}
