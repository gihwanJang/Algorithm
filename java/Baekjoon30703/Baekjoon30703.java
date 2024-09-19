import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Problem {
    int n;
    int[] inits;
    int[] goals;
    int[] gaps;

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
        inits = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        goals = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        gaps = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        solve();
    }

    private void solve() {
        int max;
        int[] count = new int[n];
        count[0] = Math.abs(inits[0] - goals[0]);
        if (count[0] % gaps[0] > 0) {
            System.out.println(-1);
            return;
        }
        max = count[0] / gaps[0];
        for (int i = 1; i < n; ++i) {
            count[i] = Math.abs(inits[i] - goals[i]);
            if (count[i] % gaps[i] > 0 || (count[i-1] / gaps[i-1]) % 2 != (count[i] / gaps[i]) % 2) {
                System.out.println(-1);
                return;
            }
            max = Math.max(max, count[i] / gaps[i]);
        }
        System.out.println(max);
    }
}

public class Baekjoon30703 {
    public static void main(String[] args) {
        new Problem();
    }
}
