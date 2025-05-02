import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int a, b, d;

    public Edge(int a, int b, int d) {
        this.a = a;
        this.b = b;
        this.d = d;
    }

    @Override
    public int compareTo(Edge o) {
        return d - o.d;
    }
}

class Problem {
    private StringBuilder sb;
    private int n, m, t, s, g, h;
    private List<List<Edge>> map;
    private PriorityQueue<Edge> pq;

    public Problem() {
        sb = new StringBuilder();
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws Exception {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int T = Integer.parseInt(br.readLine()); T > 0; --T) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            
        }
    }

    private void output() {
        System.out.print(sb.toString());
    }
}

public class Baekjoon9370 {
    public static void main(String[] args) {
        new Problem();
    }
}
