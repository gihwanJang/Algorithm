import java.io.*;
import java.util.*;

class Problem {
    private int[][] in;

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        in = new int[3][];
        for (int i = 0; i < 3; ++i) {
            in[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        solve();
    }

    private void solve() {
        StringBuilder sb = new StringBuilder();
        int idxA = 0;
        int idxB = 0;
        int size = in[0][0] + in[0][1];

        for (int i = 0; i < size; ++i) {
            if (in[1][idxA] < in[2][idxB]) {
                sb.append(in[1][idxA]).append(" ");

                if (idxA == in[0][0]-1) {
                    in[1][idxA] = Integer.MAX_VALUE;
                } else {
                    ++idxA;
                }
            } else {
                sb.append(in[2][idxB]).append(" ");

                if (idxB == in[0][1]-1) {
                    in[2][idxB] = Integer.MAX_VALUE;
                } else {
                    ++idxB;
                }
            }
        }
        System.out.println(sb.toString());
    }
}

public class Baekjoon11728 {
    public static void main(String[] args) {
        new Problem();
    }
}
