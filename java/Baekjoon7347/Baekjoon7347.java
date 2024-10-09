import java.io.*;
import java.util.*;

class Problem {
    private static final StringBuilder SB = new StringBuilder();

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t > 0; --t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int even = 0;
            int odd = 0;
            int n = Integer.parseInt(st.nextToken());

            for (int i = 0; i < n; ++i) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    if (i % 2 == 0) {
                        ++even;
                    } else {
                        ++odd;
                    }
                }
            }
            solve(n, even, odd);
        }
        System.out.print(SB.toString());
    }

    private void solve(int n, int even, int odd) {
        if (n%2==1 || (n%2==0 && Math.abs(even-odd)<=1)) {
            SB.append("YES").append("\n");
        } else {
            SB.append("NO").append("\n");
        }
    }
}

public class Baekjoon7347 {
    public static void main(String[] args) {
        new Problem();
    }
}
