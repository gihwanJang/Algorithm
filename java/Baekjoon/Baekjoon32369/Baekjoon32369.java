import java.io.*;
import java.util.*;

class Problem {
    private int[] nums;

    public Problem() {
        try {
            input();
            solve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private void solve() {
        int a = 1;
        int b = 1;

        for (int i = 0; i < nums[0]; ++i) {
            a += nums[1];
            b += nums[2];
            if (a < b) {
                int temp = a;
                a = b;
                b = temp;
            } else if (a == b) {
                b -= 1;
            }
        }
        System.out.println(a + " " + b);
    }
}

public class Baekjoon32369 {
    public static void main(String[] args) {
        new Problem();
    }
}
