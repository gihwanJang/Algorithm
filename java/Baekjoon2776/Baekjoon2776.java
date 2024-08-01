import java.io.*;
import java.util.*;

public class Baekjoon2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t > 0; --t) {
            int n = Integer.parseInt(br.readLine());
            Set<Integer> set = new HashSet<>();
            Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(set::add);
            int m = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(i -> {
                if (set.contains(i)) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            });
            System.out.print(sb.toString());
        }
    }
}
