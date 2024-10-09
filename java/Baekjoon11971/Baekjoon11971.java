import java.io.*;
import java.util.*;

class Problem {
    private int n;
    private int m;
    private int[] sectionSpeed;
    private int[] carSpeed;

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sectionSpeed = new int[100];
        carSpeed = new int[100];
        for (int i = 0, p = 0; i < n; ++i) {
            int[] section = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int j = 0; j < section[0]; ++j, ++p) {
                sectionSpeed[p] = section[1];
            }
        }
        for (int i = 0, p = 0; i < m; ++i) {
            int[] car = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int j = 0; j < car[0]; ++j, ++p) {
                carSpeed[p] = car[1];
            }
        }
        solve();
    }

    private void solve() {
        int max = 0;
        
        for (int i = 0; i < 100; ++i) {
            max = Math.max(max, carSpeed[i] - sectionSpeed[i]);
        }
        System.out.println(max);
    }
}

public class Baekjoon11971 {
    public static void main(String[] args) {
        new Problem();
    }
}
