import java.io.*;
import java.util.*;

class Problem {
    private String str;

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        solve();
    }

    private void solve() {
        int count = 0;
        for (int i = 0; i < str.length(); ++i) {
            count = Math.max(count, getMax(i));
        }
        System.out.println(count);
    }

    private int getMax(int k) {
        int ret = 0;
        int s = k;
        int[] map = new int[str.length()];

        for (int e = k + 1; e < str.length(); ++e) {
            while (s > k && str.charAt(e) != str.charAt(s)) {
                s = map[s - 1];
            }
            if (str.charAt(e) == str.charAt(s)) {
                map[e] = ++s;
                ret = Math.max(ret, map[e] - k);
            }
        }
        return ret;
    }
}

public class Baekjoon1701 {
    public static void main(String[] args) {
        new Problem();
    }
}
