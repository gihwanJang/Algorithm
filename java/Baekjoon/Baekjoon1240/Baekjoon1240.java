import java.io.*;
import java.util.*;

class Node {
    int seq;
    int value;

    public Node(int seq, int value) {
        this.seq = seq;
        this.value = value;
    }   
}

class Problem {
    private int n;
    private int m;
    private int[][] query;
    private int[][] distence;
    private List<List<Node>> tree;

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

        this.tree = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            tree.add(new ArrayList<>(n));
        }
        this.distence = new int[n][n];
        for (int i = 1; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken());

            tree.get(s).add(new Node(e, v));
            tree.get(e).add(new Node(s, v));
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
        Node curr;
        Stack<Node> stack = new Stack<>();

        visited[start] = true;
        stack.add(new Node(start, 0));
        while (!stack.isEmpty()) {
            curr = stack.pop();
            
            for (Node n : tree.get(curr.seq)) {
                if (!visited[n.seq]) {
                    visited[n.seq] = true;
                    distence[start][n.seq] = curr.value + n.value;
                    stack.add(new Node(n.seq, curr.value + n.value));
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
