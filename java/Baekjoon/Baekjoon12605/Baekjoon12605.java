import java.io.*;
import java.util.*;

class Problem {
    private String[][] strings;

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        strings = new String[Integer.parseInt(br.readLine())][];
        for (int i = 0; i < strings.length; ++i) {
            strings[i] = br.readLine().split(" ");
        }
        solve();
    }

    private void solve() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strings.length; ++i) {
            sb.append("Case #").append(i + 1).append(": ");
            for (int j = strings[i].length - 1; j >= 0; --j) {
                sb.append(strings[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}

public class Baekjoon12605 {
    public static void main(String[] args) {
        new Problem();
    }
}
