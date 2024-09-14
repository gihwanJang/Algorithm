import java.io.*;
import java.util.*;

class Problem {
    private int n;
    private int[] s;
    private List<List<Integer>> p; 

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        s = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        p = new ArrayList<>(5);

        for (int i = 0; i < 5; ++i) {
            p.add(new ArrayList<>());
        }
        for (int i = 0; i < n; ++i) {
            int[] v = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            p.get(v[0] - 1).add(v[1]);
        }
        for (int i = 0; i < 5; ++i) {
            p.get(i).sort(null);
        }
        solve();
    }

    private void solve() {
        int ans = 0;
        for (int i = 0; i < s.length; ++i) {
            ans += p.get(i).get(0);
            for (int j = 1; j < s[i]; ++j) {
                ans += p.get(i).get(j);
                ans += p.get(i).get(j) - p.get(i).get(j - 1);
            }
            ans += 60;
        }
        System.out.println(ans - 60);
    }
}

public class Baekjoon29155 {
    public static void main(String[] args) {
        new Problem();
    }
}
