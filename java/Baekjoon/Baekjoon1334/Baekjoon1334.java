import java.io.*;
import java.util.*;

class Line implements Comparable<Line> {
    int start, end;

    public Line(int a, int b) {
        start = Math.min(a, b);
        end = Math.max(a, b);
    }

    @Override
    public int compareTo(Line o) {
        if(end == o.end) {
            return start - o.start;
        }
        return end - o.end;
    }
}

class Problem {
    int n, d;
    Line[] lines;

    public Problem(int n) {
        this.n = n;
        lines = new Line[n];
    }

    public int solve() {
        Arrays.sort(lines);
        return getMaximum();
    }

    private int getMaximum() {
        int max = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; ++i) {
            pq.offer(lines[i].start);
			
			while(!pq.isEmpty() && pq.peek() < lines[i].end - d) {
                pq.poll();
            }
			
			max = Math.max(max, pq.size());
        }

        return max;
    }
}

public class Baekjoon1334 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem problem = new Problem(Integer.parseInt(br.readLine()));
        
        for(int i = 0; i < problem.n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            problem.lines[i] = new Line(a, b);
        }
        problem.d = Integer.parseInt(br.readLine());

        System.out.println(problem.solve());
    }
}
