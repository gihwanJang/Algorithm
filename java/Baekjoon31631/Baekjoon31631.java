import java.io.*;
import java.util.*;

class Problem {
    private int n;
    private List<Integer> list;

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
    }

    private void solve() {
        list = new ArrayList<>(n);

        list.add(1);
        list.add(2);
        for (int i = 2; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                list.set(j, list.get(j) + 1);
            }

            int index = i % 4;
            if (index % 2 == 0) {
                index = i >> 1;
            } else if (index == 1) {
                index = (i-1) >> 1;
            } else {
                index = ((i-1) >> 1) + 1;
            }
            list.add(index, 1);
        }
    }

    private void output() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb.toString());
    }
}

public class Baekjoon31631 {
    public static void main(String[] args) {
        new Problem();
    }
}
