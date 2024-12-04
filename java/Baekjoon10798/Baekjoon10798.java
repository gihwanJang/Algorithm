import java.io.*;
import java.util.*;

class Problem {
    private String[] strs;

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        strs = new String[5];
        for (int i = 0; i < 5; ++i) {
            strs[i] = br.readLine();
        }
        solve();
    }

    private void solve() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 15; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (strs[j].length() > i) {
                    sb.append(strs[j].charAt(i));
                }
            }
        }

        System.out.println(sb.toString());
    }
}

public class Baekjoon10798 {
    public static void main(String[] args) {
        new Problem();
    }
}
