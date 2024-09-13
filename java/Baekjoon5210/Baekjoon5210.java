import java.io.*;
import java.util.*;

class Problem {
    private StringBuilder SB = new StringBuilder();

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            List<String> name = new ArrayList<>();
            for (int i = Integer.parseInt(br.readLine()); i > 0; --i) {
                name.add(br.readLine());
            }
            solve(name, br.readLine().toLowerCase(), t);
        }
        System.out.print(SB.toString());
    }

    private void solve(List<String> name, String s, int t) {
        SB.append("Data Set ").append(t + 1).append(":\n");
        for (String n : name) {
            String temp = n.toLowerCase();
            int idx = 0;
            for (int i = 0; i < n.length(); ++i) {
                if (s.charAt(idx) == temp.charAt(i)) {
                    ++idx;
                }
                if (idx == s.length()) {
                    SB.append(n).append("\n");
                    break;
                }
            }
        }
    }
}

public class Baekjoon5210 {
    public static void main(String[] args) {
        new Problem();
    }
}
