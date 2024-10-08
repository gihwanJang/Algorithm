import java.io.*;
import java.util.*;

class Problem {
    private int n;
    private int y;

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
        for (int i = 0; i < n; ++i) {
            int[] terms = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            y += terms[0] * terms[1];
        }
        System.out.println(y);
    }
}

public class Baekjoon14730 {
    public static void main(String[] args) {
        new Problem();
    }
}
