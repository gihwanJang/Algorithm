import java.io.*;
import java.util.*;

class Problem {
    private int n;
    private int[] size;
    private int shirt;
    private int pen;

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
        size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringTokenizer st = new StringTokenizer(br.readLine());
        shirt = Integer.parseInt(st.nextToken());
        pen = Integer.parseInt(st.nextToken());
        solve();
    }

    private void solve() {
        int shirtCount = 0;
        for (int i = 0; i < 6; ++i) {
            shirtCount += size[i] / shirt;
            if (size[i] % shirt != 0) {
                ++shirtCount;
            }
        }
        System.out.println(shirtCount);
        System.out.println((n / pen) + " " + (n % pen));
    }
}

public class Baekjoon30802 {
    public static void main(String[] args) {
        new Problem();
    }
}
