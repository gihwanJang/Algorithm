import java.io.*;
import java.util.*;

class Problem {
    int n, p;
    String s;
    StringBuilder sb = new StringBuilder();

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        s = br.readLine();
    }

    private void solve() {
        String[] expression;

        for (int i = 0; i < s.length(); i++) {
            
        }
    }

    private void output() {
        System.out.println(sb.length());
        System.out.println(sb.toString());
    }
}

public class A {
    public static void main(String[] args) {
        new Problem();
    }
}