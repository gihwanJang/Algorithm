import java.io.*;
import java.util.*;

class Problem {
    private int n;

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
        solve();
    }

    private void solve() {
        int count = 0;

        for (int i = 0, j = 1; i < n; i += j++) {
            if ((n - i) % j == 0) {
                ++count;
            }
        }
        System.out.println(count);
    }
}

public class Baekjoon2018 {
    public static void main(String[] args) {
        new Problem();
    }
}
