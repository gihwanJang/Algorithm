import java.io.*;
import java.util.*;

class Problem {
    int n, h;
    int[] card;

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        card = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private int solve() {
        for (int i = 0; i < n; ++i) {
            h -= card[i];
            if (h <= 0) {
                return (i + 1);
            }
        }
        return -1;
    }

    private void output() {
        System.out.println(solve());
    }
}

public class A {
    public static void main(String[] args) throws IOException {
        new Problem();
    }
}
