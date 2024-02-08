import java.io.*;
import java.util.*;

class Problem {
    int n;
    int edges;
    boolean[][] map;
    List<Integer> leftEdge;

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int solve() {
        boolean[] visited = new boolean[n];

        leftEdge = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                leftEdge.add(0);
                DFS(visited, i);
            }
        }
        return getCount();
    }

    private void DFS(boolean[] visited, int start) {
        int curr = start;
        Stack<Integer> stack = new Stack<>();

        stack.add(curr);
        while (!stack.isEmpty()) {
            curr = stack.pop();
            if (!visited[curr]) {
                visited[curr] = true;
                leftEdge.set(leftEdge.size() - 1, leftEdge.get(leftEdge.size() - 1) + 1);
                for (int i = 0; i < n; ++i) {
                    if (map[curr][i]) {
                        stack.add(i);
                    }
                }
            }
        }
    }

    private int getCount() {
        int sum = 0;

        if (leftEdge.size() == 1) {
            return 0;
        }
        for (int i = 0; i < leftEdge.size(); ++i) {
            if (leftEdge.get(i) == 1) {
                return -1;
            }
            sum += leftEdge.get(i) - 1;
        }
        if (leftEdge.size() - 1 <= edges / 2 - sum) {
            return leftEdge.size() - 1;
        }
        return -1;
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        this.edges = 0;
        this.n = Integer.parseInt(br.readLine());
        this.map = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            String line = br.readLine();

            for (int j = 0; j < n; ++j) {
                if (line.charAt(j) == 'Y') {
                    map[i][j] = true;
                    ++edges;
                }
            }
        }
    }

    private void output() {
        System.out.println(solve());
    }
}

public class Baekjoon1119 {
    public static void main(String[] args) {
        new Problem();
    }
}