import java.io.*;
import java.util.*;

class Location {
    int node;
    int value;

    public Location(int node, int value) {
        this.node = node;
        this.value = value;
    }   
}

class Problem {
    private int n;
    private int m;
    private int[][] tree;
    private int[][] query;
    private int[][] distence;

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

        this.tree = new int[n][n];
        this.distence = new int[n][n];
        for (int i = 1; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken());

            tree[s][e] = v;
            tree[e][s] = v;
        }

        this.query = new int[m][2];
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            query[i][0] = Integer.parseInt(st.nextToken()) - 1;
            query[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }
    }

    private void output() {
        System.out.print(solve());
    }

    private String solve() {
        boolean[] visited = new boolean[n];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; ++i) {
            makeRoute(visited, i);
            Arrays.fill(visited, false);
        }
        for (int i = 0; i < m; ++i) {
            sb.append(distence[query[i][0]][query[i][1]]).append("\n");
        }
        return sb.toString();
    }

    private void makeRoute(boolean[] visited, int start) {
        Location curr;
        Stack<Location> stack = new Stack<>();

        visited[start] = true;
        stack.add(new Location(start, 0));
        while (!stack.isEmpty()) {
            curr = stack.pop();
            
            for (int i = 0; i < n; ++i) {
                if (tree[curr.node][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    distence[start][i] = curr.value + tree[curr.node][i];
                    stack.add(new Location(i, curr.value + tree[curr.node][i]));
                }
            }
        }
    }
}

public class Baekjoon1240 {
    public static void main(String[] args) {
        new Problem();
    }
}
