import java.io.*;
import java.util.*;

class Query {
    Character q;
    int x, y;

    public Query(Character q) {
        this.q = q;
    }

    public Query(Character q, int x, int y) {
        this.q = q;
        this.x = x;
        this.y = y;
    }
}

class Problem {
    private StringBuilder ANSWER = new StringBuilder();
    private int n, m, k;
    private int[] a, b;
    private Query[] queries;

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
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        a = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        b = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        k = Integer.parseInt(br.readLine());

        queries = new Query[k];
        for (int i = 0; i < k ; ++i) {
            line = br.readLine().split(" ");
            if (line[0].equals("U")) {
                queries[i] = new Query(line[0].charAt(0), Integer.parseInt(line[1]), Integer.parseInt(line[2]));
            } else {
                queries[i] = new Query(line[0].charAt(0));
            }
        }
    }

    private void solve() {
        int[] aMin = getAMin();
        int[] bMin = getBMin();

        for (int i = 0; i < k; ++i) {
            if (queries[i].q.equals('U')) {
                if (queries[i].x <= n) { // a
                    a[queries[i].x - 1] = queries[i].y;

                    if (queries[i].x-1 == aMin[0]) {
                        if (queries[i].y > aMin[1]) {
                            aMin = getAMin();
                        }
                    } else {
                        if (queries[i].y < aMin[1]) {
                            aMin[0] = queries[i].x-1;
                            aMin[1] = queries[i].y;
                        } else if (queries[i].y == aMin[1] && queries[i].x-1 < aMin[0]) {
                            aMin[0] = queries[i].x-1;
                        }
                    }
                } else { // b
                    int idx = queries[i].x - n - 1;
                    b[idx] = queries[i].y;

                    if (idx == bMin[0]) {
                        if (queries[i].y > bMin[1]) {
                            bMin = getBMin();
                        }
                    } else {
                        if (queries[i].y < bMin[1]) {
                            bMin[0] = idx;
                            bMin[1] = queries[i].y;
                        } else if (queries[i].y == bMin[1] && idx < bMin[0]) {
                            bMin[0] = idx;
                        }
                    }
                }
            } else {
                ANSWER.append(aMin[0] + 1).append(' ').append(bMin[0] + 1 + n).append("\n");
            }
        }
    }

    private int[] getAMin() {
        int[] aMin = {0,Integer.MAX_VALUE};
        for(int i = 0; i < n; ++i) {
            if (a[i] < aMin[1]) {
                aMin[0] = i;
                aMin[1] = a[i];
            }
        }
        return aMin;
    }

    private int[] getBMin() {
        int[] bMin = {0,Integer.MAX_VALUE};
        for (int i = 0; i < m; ++i) {
            if (b[i] < bMin[1]) {
                bMin[0] = i;
                bMin[1] = b[i];
            }
        }
        return bMin;
    }

    private void output() {
        System.out.print(ANSWER.toString());
    }
}

public class Baekjoon29811 {
    public static void main(String[] args) {
        new Problem();
    }
}
