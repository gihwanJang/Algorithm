import java.io.*;
import java.util.*;

class Problem {
    private int n;

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (long num : Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray()) {
            long sqrt = (long)Math.sqrt(num);
            sb.append((sqrt * sqrt) == num ? 1 : 0).append(" ");
        }
        System.out.println(sb.toString());
    }
}

public class Baekjoon11815 {
    public static void main(String[] args) {
        new Problem();
    }
}
