import java.io.*;
import java.util.*;

class Line implements Comparable<Line> {
    int a, b;
    boolean isCrossed = true;

    @Override
    public int compareTo(Line o) {
        return a - o.a;
    }
}

public class Baekjoon2568 {
    int n;
    List<Line> lines;

    private int binarySearch(List<int[]> LIS, int target) {
        int lo = 0, hi = LIS.size(), mid;

        while(lo < hi) {
            mid = (lo + hi) / 2;
            if(LIS.get(mid)[0] < target) lo = mid+1;
            else hi = mid;
        }

        return lo;
    }

    private void backTraking(int[] prev, int i) {
        lines.get(i).isCrossed = false;
        if(i != prev[i]) {backTraking(prev, prev[i]);}
    }

    private void removeLine() {
        int[] prev = new int[n];
        List<int[]> LIS = new ArrayList<>(lines.size());

        LIS.add(new int[]{lines.get(0).b, 0});
        for(int i = 1, idx; i < n; ++i) {
            if(LIS.get(LIS.size()-1)[0] < lines.get(i).b) {
                prev[i] = LIS.get(LIS.size()-1)[1];
                LIS.add(new int[]{lines.get(i).b, i});
            }
            else {
                idx = binarySearch(LIS, lines.get(i).b);
                prev[i] = idx == 0 ? i : LIS.get(idx-1)[1];
                LIS.get(idx)[0] = lines.get(i).b;
                LIS.get(idx)[1] = i;
            }
        }

        backTraking(prev, LIS.get(LIS.size()-1)[1]);
    }

    public String solve() {
        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        Collections.sort(lines);
        removeLine();

        for(Line l : lines) {
            if(l.isCrossed) {
                sb.append(l.a).append("\n");
                ++cnt;
            }
        }

        return sb.insert(0, cnt + "\n").toString();
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon2568 problem = new Baekjoon2568();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        problem.n = Integer.parseInt(st.nextToken());
        problem.lines = new ArrayList<>(problem.n);
        for (int i = 0; i < problem.n; ++i) {
            st = new StringTokenizer(br.readLine());
            problem.lines.add(new Line());
            problem.lines.get(i).a = Integer.parseInt(st.nextToken());
            problem.lines.get(i).b = Integer.parseInt(st.nextToken());
        }

        System.out.print(problem.solve());
    }
}