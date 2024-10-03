import java.io.*;
import java.util.*;

class Problem {
    private int n;
    private int[] a;
    private int[] b;
    private int[] c;
    private int[] d;

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        b = new int[n];
        c = new int[n];
        d = new int[n];
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
        }
        solve();
    }

    private void solve() {
        long res = 0;
        Map<Integer, Integer> map = new HashMap<>(100000000);

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                map.put(a[i] + b[j], map.getOrDefault(a[i] + b[j], 0) + 1);
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (map.containsKey((c[i] + d[j]) * -1)) {
                    res += map.get((c[i] + d[j]) * -1);
                }
            }
        }
        System.out.println(res);
    }
}

public class Baekjoon7453 {
    public static void main(String[] args) {
        new Problem();
    }
}
