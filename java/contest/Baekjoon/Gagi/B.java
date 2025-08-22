import java.io.*;
import java.util.*;

class Problem {
    private int n;
    private int[] query;
    private StringBuilder sb;

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        query = new int[n];
        for (int i = 0 ; i < n; ++i) {
            query[i] = Integer.parseInt(br.readLine());
        }
    }

    private void output() {
        Arrays.stream(query)
                .forEach(this::solve);
        System.out.println(sb.toString());
    }

    private void solve(int n) {
        for ()
    }
}

public class B {
    public static void main(String[] args) {
        new Problem();
    }
}
