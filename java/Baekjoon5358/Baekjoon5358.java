import java.io.*;
import java.util.*;

class Problem {
    List<String> strings;

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        String s = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        strings = new ArrayList<>();

        while((s = br.readLine()) != null) {
            strings.add(s);
        }
        solve();
    }

    private void solve() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.size(); ++i) {
            for (int j = 0; j < strings.get(i).length(); ++j) {
                if (strings.get(i).charAt(j) == 'i') {
                    sb.append('e');
                } else if (strings.get(i).charAt(j) == 'e') {
                    sb.append('i');
                } else if (strings.get(i).charAt(j) == 'I') {
                    sb.append('E');
                } else if (strings.get(i).charAt(j) == 'E') {
                    sb.append('I');
                } else {
                    sb.append(strings.get(i).charAt(j));
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}

public class Baekjoon5358 {
    public static void main(String[] args) {
        new Problem();
    }
}
