import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Problem {
    private int n;
    private List<List<Integer>> chart;

    public Problem() {
        input();
        output();
    }

    private int getTime() {
        return DFS(0);
    }

    private int DFS(int start) {
        if (chart.get(start).size() == 0) {
            return 0;
        }

        int maxTime = 0;
        List<Integer> times = chart.get(start).stream()
                .mapToInt(i -> DFS(i.intValue()))
                .boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        
        for (int i = 1; i <= times.size(); ++i) {
            maxTime = Math.max(maxTime, i + times.get(i - 1));
        }
        return maxTime;
    }

    private void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            chart = new ArrayList<>(n);
            IntStream.range(0, n).forEach(i -> chart.add(new ArrayList<>()));

            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            IntStream.range(1, n).forEach(i -> chart.get(Integer.parseInt(st.nextToken())).add(i));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    private void output() {
        System.out.println(getTime());
    }
}

public class Baekjoon1135 {
    public static void main(String[] args) {
        new Problem();
    }
}
