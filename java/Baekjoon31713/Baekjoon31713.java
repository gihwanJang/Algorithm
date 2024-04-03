import java.io.*;
import java.util.*;

class Problem {
    private int t;
    private int[][] queries;

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
        t = Integer.parseInt(br.readLine());
        queries = new int[t][2];
        for (int i = 0; i < t; ++i) {
            queries[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    private void output() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; ++i) {
            sb.append(solve(queries[i][0], queries[i][1])).append("\n");
        }
        System.out.print(sb.toString());
    }

    private int solve(int stems, int leaves) {
        if (stems * 3 <= leaves && leaves <= stems * 4) {
            return 0;
        } else if (stems * 3 > leaves) {
            return stems * 3 - leaves;
        }
        return 1 + solve(stems + 1, leaves);
    }
}

public class Baekjoon31713 {
    public static void main(String[] args) {
        new Problem();
    }
}
