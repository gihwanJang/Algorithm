import java.io.*;
import java.util.*;

class Problem {
    private final int INF = 123456789;

    private int n, m;
    private int[][] qureys;
    private int[][] graph;

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        this.n = Integer.parseInt(st.nextToken());
        this.m = Integer.parseInt(st.nextToken());

        this.graph = new int[n][n];
        Arrays.stream(graph).forEach(i -> Arrays.fill(i, INF));
        for (int i = 0; i < n; ++i) {
            graph[i][i] = 0;
        }
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            
            if (Integer.parseInt(st.nextToken()) == 1) {
                graph[e][s] = 0;
            } else {
                graph[e][s] = 1;
            }
            graph[s][e] = 0;
        }

        this.qureys = new int[Integer.parseInt(br.readLine())][2];
        for (int i = 0; i < qureys.length; ++i) {
            st = new StringTokenizer(br.readLine());
            qureys[i][0] = Integer.parseInt(st.nextToken()) - 1;
            qureys[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }
    }

    private void output() {
        StringBuffer sb = new StringBuffer();

        floydWarshall();
        for (int[] qurey : qureys) {
            sb.append(graph[qurey[0]][qurey[1]]).append("\n");
        }
        System.out.print(sb.toString());
    }

    private void floydWarshall() {
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    graph[i][j] = Math.min(graph[i][k] + graph[k][j], graph[i][j]);
                }
            }
        }
    }
}

public class Baekjoon11562 {
    public static void main(String[] args) {
        new Problem();
    }
}
