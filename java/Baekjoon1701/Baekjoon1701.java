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
            count = Math.max(count, getMax(str.substring(i)));
        }
        System.out.println(count);
    }

    private int getMax(String subStr) {
        int ret = 0;
        int s = 0;
        int[] map = new int[subStr.length()];

        for (int e = 1; e < subStr.length(); ++e) {
            while (s > 0 && subStr.charAt(e) != subStr.charAt(s)) {
                s = map[s - 1];
            }
            if (subStr.charAt(e) == subStr.charAt(s)) {
                map[e] = ++s;
                ret = Math.max(ret, map[e]);
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
